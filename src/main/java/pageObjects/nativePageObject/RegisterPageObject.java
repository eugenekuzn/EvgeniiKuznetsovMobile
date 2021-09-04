package pageObjects.nativePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject {
    @AndroidFindBy(id = PathNames.iDPackageName + "registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value = 'user@example.com']")
    private WebElement emailInputField;

    @AndroidFindBy(id = PathNames.iDPackageName + "registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value = 'TimApple']")
    private WebElement usernameInputField;

    @AndroidFindBy(id = PathNames.iDPackageName + "registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value = 'Required']")
    private WebElement passwordInputField;

    @AndroidFindBy(id = PathNames.iDPackageName + "registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value = 'Repeat please']")
    private WebElement confirmPasswordInputField;

    @AndroidFindBy(id = PathNames.iDPackageName + "register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name = 'Register new account']")
    private WebElement registerNewAccountButton;

    protected RegisterPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
