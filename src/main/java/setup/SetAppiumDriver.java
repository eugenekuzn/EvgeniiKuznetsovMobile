package setup;

import static java.lang.String.format;

import io.appium.java_client.AppiumDriver;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import testValue.DriverProperties;

public abstract class SetAppiumDriver implements IDriver {

    private static AppiumDriver appiumDriver; // singleton

    protected void setAppiumDriver(String platformName, String deviceName, String udid, String browserName, String app,
                                   String appPackage, String appActivity, String bundleId) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("bundleId", bundleId);

        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        try {
            String key = URLEncoder.encode(DriverProperties.API_KEY, StandardCharsets.UTF_8.name());
            appiumDriver = new AppiumDriver(new URL(
                format("https://%s:%s@%s/wd/hub", DriverProperties.PROJECT_NAME, key, DriverProperties.APPIUM_HUB)),
                capabilities);
        } catch (MalformedURLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }
}
