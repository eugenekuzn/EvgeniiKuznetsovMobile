package scenarios;

import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;
import setup.BaseTest;
import testData.TestDataProvider;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"},
          description = "This test verify you can register new account and login to it.",
          dataProvider = "dataForRegistrationAndLogin", dataProviderClass = TestDataProvider.class)
    public void registerAndLoginTest(String mail, String username, String password)
        throws IllegalAccessException, NoSuchFieldException {
        testApp.openRegisterPage();
        testApp.registration(mail, username, password);
        testApp.login(mail, password);

        assertThat("Budget Activity Page is opened: ",
            testApp.checkTheBudgetActivityIsOpened().equals("BudgetActivity"));
    }
}
