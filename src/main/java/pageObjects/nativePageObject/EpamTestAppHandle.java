package pageObjects.nativePageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.lang.reflect.Field;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import testValue.ElementNames;

public class EpamTestAppHandle {
    LoginPageObject loginPageObject;
    RegisterPageObject registerPageObject;
    BudgetActivityPageObject budgetActivityPageObject;

    public EpamTestAppHandle(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        loginPageObject = new LoginPageObject(appiumDriver);
        registerPageObject = new RegisterPageObject(appiumDriver);
        budgetActivityPageObject = new BudgetActivityPageObject(appiumDriver);
    }

    public void openRegisterPage() throws NoSuchFieldException, IllegalAccessException {
        getElement(loginPageObject, ElementNames.REGISTER_BUTTON).click();
    }

    public void registration(String mail, String username, String password)
        throws NoSuchFieldException, IllegalAccessException {
        getElement(registerPageObject, ElementNames.EMAIL_INPUT_FIELD).sendKeys(mail);
        getElement(registerPageObject, ElementNames.USERNAME_INPUT_FIELD).sendKeys(username);
        getElement(registerPageObject, ElementNames.PASSWORD_INPUT_FIELD).sendKeys(password);
        getElement(registerPageObject, ElementNames.CONFIRM_PASSWORD_INPUT_FIELD).sendKeys(password);
        getElement(registerPageObject, ElementNames.REGISTER_BUTTON).click();
    }

    public void login(String login, String password) throws NoSuchFieldException, IllegalAccessException {
        getElement(loginPageObject, ElementNames.LOGIN_INPUT_FIELD).sendKeys(login);
        getElement(loginPageObject, ElementNames.PASSWORD_INPUT_FIELD).sendKeys(password);
        getElement(loginPageObject, ElementNames.SIGN_IN_BUTTON).click();
    }

    public String checkTheBudgetActivityIsOpened() throws NoSuchFieldException, IllegalAccessException {
        return getElement(budgetActivityPageObject, ElementNames.PAGE_TITLE).getText();
    }

    private WebElement getElement(Object pageObject, String nameElement)
        throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = pageObject.getClass().getDeclaredField(nameElement);
        field.setAccessible(true);
        return (WebElement) field.get(pageObject);
    }
}
