package pageObjects.webPageObject;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {

    @FindBy(xpath = "//div[@id='rso']/div")
    protected static List<WebElement> searchResults;

    protected GoogleResultPage(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

}
