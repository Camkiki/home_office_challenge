package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tolaf on 02/05/2018.
 * subclass for Vehicle Home Page
 */
public class VehicleHomePage extends BasePage {
    private String homePageTitle = "Get vehicle information from DVLA - GOV.UK";

    @FindBy(css = ".mainstream.js-enabled")
    private WebElement pageBody;

    @FindBy(css=".gem-c-button.gem-c-button--start")        //.pub-c-button.pub-c-button--start
    private WebElement btnStartNow;

    public void assertHomePage() {
        Assert.assertEquals(getCurrentPageTitle(), homePageTitle);
        shouldBeVisible(btnStartNow);
        Assert.assertTrue(checkPageBody().contains("Get vehicle information from DVLA"));
        Assert.assertFalse(checkPageBody().contains("Check if a vehicle is taxed and has an MOT"));
    }

    private String checkPageBody(){
        return pageBody.getText();
    }

    public void clickStartNow(){
        clickOnButton(btnStartNow);
    }
}
