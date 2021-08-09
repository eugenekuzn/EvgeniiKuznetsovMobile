package testValue;

public abstract class DriverProperties {
    public static final String PROJECT_NAME = "EPM-TSTF";
    public static final String APPIUM_HUB = "mobilecloud.epam.com";
    public static final String API_KEY = SecurePropertiesHandler.secureProperties().getProperty("api_key");
}
