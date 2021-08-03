package pageObjects.webPageObject;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GoogleMobileSiteHandler {
    AppiumDriver localDriver;
    GoogleHomePage homePage;
    GoogleResultPage resultsPage;

    public GoogleMobileSiteHandler(AppiumDriver appiumDriver) {
        this.localDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
        homePage = new GoogleHomePage(appiumDriver);
        resultsPage = new GoogleResultPage(appiumDriver);
    }

    public void openGoogleHomePage() {
        localDriver.get(homePage.URL);
    }

    public void search(String query){
        homePage.searchField.sendKeys(query);
    }

    public List<WebElement> getSearchResults(){
        return resultsPage.searchResults;
    }
}
