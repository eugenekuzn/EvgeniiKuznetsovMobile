package setup;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;
import pageObjects.nativePageObject.EpamTestAppHandle;
import pageObjects.webPageObject.GoogleMobileSiteHandler;

public class BaseTest extends SetAppiumDriver {

    public EpamTestAppHandle testApp;
    public GoogleMobileSiteHandler googleSite;

    @Parameters({"appType", "platformName", "deviceName", "udid", "browserName", "app", "appPackage", "appActivity",
                    "bundleId"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String appType, String platformName, @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app, @Optional("") String appPackage, @Optional("") String appActivity,
                      @Optional("") String bundleId)
        throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId);
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
