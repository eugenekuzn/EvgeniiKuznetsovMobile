package scenarios;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import setup.BaseTest;
import testValue.TestValues;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "This test verify you can open Google home page and find necessary result")
    public void simpleSecondWebTest() throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        //open home Google page
        googleSite.openGoogleHomePage();
        //search "EPAM"
        googleSite.search(TestValues.QUERY + "\n");
        //assert that results contain "EPAM"
        googleSite.getSearchResults().forEach(element -> {
            MatcherAssert.assertThat("Search results contain \"" + TestValues.QUERY + "\": ",
                element.getText().contains(TestValues.QUERY));
        });

        System.out.println("Test done");
    }
}
