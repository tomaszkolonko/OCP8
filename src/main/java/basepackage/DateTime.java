package basepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class DateTime {

    private DateTime() {}

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.list(System.out);

        Properties ownProperties = new Properties();

        createNewPropertiesFile();
        readPropertiesFile(ownProperties);
    }

    private static void createNewPropertiesFile() {
        Properties properties = new Properties();
        properties.setProperty("server.port", "9998");
        properties.setProperty("debug.level", "WARN");
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("myProperties.properties");
            properties.store(fileOutputStream,  "Server Properties File");
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("createNewPropertiesFile unsuccessfull " + e);
        }
    }

    private static void readPropertiesFile(Properties ownProperties) {
        try {
            FileInputStream in = new FileInputStream(("src/main/resources/OCP8.properties"));
            ownProperties.load(in);
            ownProperties.list(System.out);
            in.close();
        } catch (IOException e) {
            System.out.println("Exception caught");
        }

        System.out.println("\n===========================\n");

        // use the properties
        System.out.println(ownProperties.getProperty("greetingOne"));
        System.out.println(ownProperties.getProperty("greetingTwo"));
        System.out.println(ownProperties.getProperty("greetingThree"));

        ownProperties.setProperty("test", "test");
        ownProperties.list(System.out);
    }

}
