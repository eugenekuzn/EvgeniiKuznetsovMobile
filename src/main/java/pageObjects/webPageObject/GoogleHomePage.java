package pageObjects.webPageObject;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
    protected static String URL = "https://www.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    protected static WebElement searchField;

    protected GoogleHomePage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }
}
