package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by tolaf on 02/05/2018.
 * subclass for Confirm Vehicle Page
 */
public class ConfirmVehiclePage extends BasePage {
    private String confirmPageTitle = "Check if a vehicle is taxed and has an MOT";

    @FindBy(css = ".js-enabled")
    private WebElement pageBody;

    @FindBy(css = ".reg-mark")
    private WebElement registrationNumber;

    @FindBy(xpath = ".//*[@id='pr3']/div/ul/li[2]/span[2]/strong")
    private WebElement vehicleMake;

    @FindBy(xpath = ".//*[@id='pr3']/div/ul/li[3]/span[2]/strong")
    private WebElement vehicleColour;

    public void assertConfirmPage(){
        Assert.assertEquals(getCurrentPageTitle(), confirmPageTitle);
        shouldBeVisible(registrationNumber);
        shouldBeVisible(vehicleMake);
        shouldBeVisible(vehicleColour);
        Assert.assertTrue(checkPageBody().contains("Check if a vehicle is taxed and has an MOT"));
        Assert.assertTrue(checkPageBody().contains("Is this the vehicle you are looking for?"));
    }

    private String checkPageBody(){
        return pageBody.getText();
    }

    public String getRegistrationNumber(){
        return registrationNumber.getText();
    }

    public String getVehicleMake(){
        return vehicleMake.getText();
    }

    public String getVehicleColour(){
        return vehicleColour.getText();
    }

    public void confirmVehicleDetails(String regnum, String make, String colour){
        Assert.assertEquals((regnum), getRegistrationNumber());
        Assert.assertEquals((make), getVehicleMake());
        Assert.assertEquals((colour), getVehicleColour());
    }
}
