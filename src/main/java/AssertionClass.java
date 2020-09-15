public class AssertionClass {

    public static void main(String[] args) {
        AssertionClass assertionClass = new AssertionClass();
        assertionClass.doSomeAssertions(2);
        assertionClass.doSomeAssertionsWithMoreInfo(-1);
    }

    private void doSomeAssertions(int x) {
        assert(x >= 0);
        // then continue with the code of this method
        System.out.println("No assertions thrown in doSomeAssertions(int x)");
    }

    private void doSomeAssertionsWithMoreInfo(int x) {
        assert(x >= 0): "Assertion faild since x (" + x + ") is NOT bigger or equal zero";
        // Then continue with the code of this mehtod
        System.out.println("No assertions thrown in doSomeAssertionsWithMoreInfo(int x)");
    }

}
