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
        useTrainProperties();
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

        System.out.println("\n=====================\n");
    }

    private static void useTrainProperties() {
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle resourceBundleEnglishUS = ResourceBundle.getBundle("Train", new Locale("en", "US"));
        System.out.println(resourceBundleEnglishUS.getString("ride") + " " + resourceBundleEnglishUS.getString("train"));

        ResourceBundle resourceBundleEnglishUK = ResourceBundle.getBundle("Train", new Locale("en", "UK"));
        System.out.println(resourceBundleEnglishUK.getString("ride") + " " + resourceBundleEnglishUK.getString("train"));

        System.out.println("\n=====================\n");
    }
}
