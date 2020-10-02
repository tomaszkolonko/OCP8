import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class Runner {

    public static void main(String[] args) {
        Locale locale = new Locale("it");
        // ResourceBundle only knows how to find the appropriate file via the filename
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Labels", locale);
        System.out.println(resourceBundle.getString("hello"));
        System.out.println("\n=====================\n");

        useResourceBundleClass();
        useTrainProperties();
        useInMemoryProperties();
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

        // ATTENTION, KEY NOT DEFINED
        // Can't find resource for bundle java.util.PropertyResourceBundle, key ridee
//        System.out.println(resourceBundleEnglishUK.getString("xxxxx"));

        System.out.println("\n=====================\n");
    }

    private static void useInMemoryProperties() {
        Map<String, String> someMap = new TreeMap<>();
        someMap.put("3000", "Bern");
        someMap.put("4000", "Basel");
        someMap.put("8000", "Zurich");

        Properties properties = new Properties();
        properties.putAll(someMap);

        Object obj = properties.get("3000");
        System.out.println((String) obj);

        Object objNotDefined = properties.get("9999");
        System.out.println(objNotDefined);

        String secondCity = properties.getProperty("4000");
        System.out.println(secondCity);

        String cityNotDefined = properties.getProperty("9999");
        System.out.println(cityNotDefined);
    }
}
