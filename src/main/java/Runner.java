import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {

    public static void main(String[] args) {
        Locale locale = new Locale("it");
        // ResourceBundle only knows how to find the appropriate file via the filename
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Labels", locale);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println("\n=====================\n");

        useResourceBundleClass();
    }

    private static void useResourceBundleClass() {
        Locale locale = new Locale("en", "CA");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Labels", locale);
        System.out.println(resourceBundle.getObject("hello"));

        locale = new Locale("fr", "CA");
        resourceBundle = ResourceBundle.getBundle("Labels", locale);
        System.out.println(resourceBundle.getObject("hello"));

        resourceBundle = ResourceBundle.getBundle("Labels");
        System.out.println(resourceBundle.getObject("hello"));

        // resourceBundle = ResourceBundle.getBundle("Labels");
        // entspricht: resourceBundle = ResourceBundle.getBundle("Labels" Locale.getDefault());
        System.out.println(Locale.getDefault());

    }

}
