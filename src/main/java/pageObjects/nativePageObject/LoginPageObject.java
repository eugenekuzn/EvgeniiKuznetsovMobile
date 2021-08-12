package pageObjects.nativePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject implements PathNames  {

    @AndroidFindBy(id = PathNames.iDPackageName + "register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = 'Register new account']")
    private WebElement registerNewAccountButton;
    @AndroidFindBy(id = PathNames.iDPackageName + "email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value = 'Sign In']")
    private WebElement signInButton;
    @AndroidFindBy(id = PathNames.iDPackageName + "login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value = 'user@example.com']")
    private WebElement loginInputField;
    @AndroidFindBy(id = PathNames.iDPackageName + "login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value = 'Required']")
    private WebElement passwordInputField;

    protected LoginPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
