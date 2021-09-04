package testValue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SecurePropertiesHandler {
    private static final String PATH_TO_PROPERTIES = "src/test/resources/properties/secure.properties";

    public static Properties secureProperties() {
        FileInputStream fileInputStream;
        Properties properties;
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties = new Properties();
            properties.load(fileInputStream);

            return properties;
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return null;
    }
}
