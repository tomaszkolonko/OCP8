import java.util.ListResourceBundle;

public class Labels_fr_CA extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                { "hello", new StringBuilder("Bonjour Canada") }
        };
    }
}
