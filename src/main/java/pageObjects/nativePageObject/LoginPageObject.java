package pageObjects.nativePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject implements PathNames  {

    @AndroidFindBy(id = iDPackageName + "register_button")
    private WebElement registerNewAccountButton;
    @AndroidFindBy(id = iDPackageName + "email_sign_in_button")
    private WebElement signInButton;
    @AndroidFindBy(id = iDPackageName + "login_email")
    private WebElement loginInputField;
    @AndroidFindBy(id = iDPackageName + "login_pwd")
    private WebElement passwordInputField;

    protected LoginPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }
}
