package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tolaf on 02/05/2018.
 * subclass for Vehicle Enquiry Page
 */
public class VehicleEnquiryPage extends BasePage {
    private String  enquiryPageTitle = "Check if a vehicle is taxed and has an MOT";

    @FindBy(css = ".js-enabled")
    private WebElement pageBody;

    @FindBy(css = "#Vrm")
    private WebElement txtRegistrationNumber;

    @FindBy(css = ".button")
    private WebElement btnContinue;

    public void assertEnquiryPage() {
        shouldBeVisible(txtRegistrationNumber);
        shouldBeVisible(btnContinue);
        Assert.assertTrue(checkPageBody().contains("Check if a vehicle is taxed and has an MOT"));
        Assert.assertTrue(checkPageBody().contains("Enter the registration number of the vehicle"));
    }

    private String checkPageBody(){
        return pageBody.getText();
    }

    public void doVehicleEnquiry(String carreg){
        shouldBeVisible(txtRegistrationNumber);
        txtRegistrationNumber.clear();
        txtRegistrationNumber.sendKeys(carreg);
        clickOnButton(btnContinue);
    }
}
