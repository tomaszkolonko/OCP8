package basepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class DateTime {

    private DateTime() {}

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.list(System.out);

        Properties ownProperties = new Properties();
        try {
            FileInputStream in = new FileInputStream(("src/main/resources/OCP8.properties"));
            ownProperties.load(in);
            ownProperties.list(System.out);
            in.close();
        } catch (IOException e) {
            System.out.println("Exception caught");
        }

        // use the properties
        System.out.println(ownProperties.getProperty("greetingOne"));

        ownProperties.setProperty("test", "test");
        ownProperties.list(System.out);







    }

}
