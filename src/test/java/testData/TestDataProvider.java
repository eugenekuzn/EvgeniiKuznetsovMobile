package testData;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "dataForRegistrationAndLogin")
    public Object[][] dataForRegistrationAndLogin() {
        return new Object[][] {{"test_mail@tmail.com", "NewTestAccount", "strongPassword"}};
    }
}
