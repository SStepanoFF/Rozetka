import java.util.Properties;
import java.io.IOException;

/**
 * Created by sstep on 12/22/2014.
 */
public class Property {
    private static final String propFile = "Rozetka.properties";

    public static String loadProperty(String name) {
        Properties proper = new Properties();
        try {
            proper.load(Property.class.getResourceAsStream(propFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";
        if (name != null) {
            value = proper.getProperty(name);
        }
        return value;
    }
}
