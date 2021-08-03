package setup;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;
import pageObjects.nativePageObject.EpamTestAppHandle;
import pageObjects.webPageObject.GoogleMobileSiteHandler;

public class BaseTest extends SetAppiumDriver {

    public EpamTestAppHandle testApp;
    public GoogleMobileSiteHandler googleSite;

    @Parameters({"platformName", "appType", "deviceName", "browserName", "app"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName, @Optional("") String browserName,
                      @Optional("") String app) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, browserName, app);
        setPageObject(appType, getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("After");
        getDriver().closeApp();
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
        System.out.println("Current app type: " + appType);
        switch (appType) {
            case "web":
                googleSite = new GoogleMobileSiteHandler(appiumDriver);
                break;
            case "native":
                testApp = new EpamTestAppHandle(appiumDriver);
                break;
            default:
                throw new Exception("Can't create a page object for " + appType);
        }
    }
}
