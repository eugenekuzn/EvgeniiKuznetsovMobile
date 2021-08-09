package pageObjects.nativePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BudgetActivityPageObject implements PathNames{

    @FindBy(xpath = titleXPath)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name = 'Budget']")
    WebElement pageTitle;

    protected BudgetActivityPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

}
