package pageObjects.nativePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject implements PathNames {
    @AndroidFindBy(id = iDPackageName + "registration_email")
    private WebElement emailInputField;
    @AndroidFindBy(id = iDPackageName + "registration_username")
    private WebElement usernameInputField;
    @AndroidFindBy(id = iDPackageName + "registration_password")
    private WebElement passwordInputField;
    @AndroidFindBy(id = iDPackageName + "registration_confirm_password")
    private WebElement confirmPasswordInputField;
    @AndroidFindBy(id = iDPackageName + "register_new_account_button")
    private WebElement registerNewAccountButton;

   protected RegisterPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
