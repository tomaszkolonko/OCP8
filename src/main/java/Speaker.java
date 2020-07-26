public class Speaker implements Speaking {
    public static void main(String[] args) {
        new Speaker().go();
    }
    @Override
    public String speakDefault() {
        return "default speaking in Child class";
    }
    void go() {
        // Default Methods
        System.out.println(Speaking.speakDefault()); // This syntax is for static methods
        System.out.println(speakDefault());
        // This does not work because Speaker can potentially implement several interfaces with default
        // methods with the same name. Therefore you need to add the interface name before super
        System.out.println(super.speakDefault());
        System.out.println(Speaking.super.speakDefault());


        System.out.println(Speaking.speakStatic());
        System.out.println(speakStatic()); // The method never got inherited !!!
        System.out.println(Speaking.super.speakStatic()); // Makes no sense.
    }
}
