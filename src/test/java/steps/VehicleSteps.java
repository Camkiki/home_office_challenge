package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ConfirmVehiclePage;
import pages.VehicleEnquiryPage;
import pages.VehicleHomePage;
import services.VehicleDetailsService;

/**
 * Created by tolaf on 02/05/2018.
 */
public class VehicleSteps {
    private static final String regNum = "KW07 LGA";            //"<registrationnumber>";
    private static final String expVehMake = "PEUGEOT";          //"<vehiclemake>";
    private static final String expVehColour = "YELLOW";         //"<vehiclecolour>";
    private String testDataFolder="/HomeOfficeChallenge/src/test/resources/testdata";

    private VehicleHomePage vehicleHomePage;
    private VehicleEnquiryPage vehicleEnquiryPage;
    private ConfirmVehiclePage confirmVehiclePage;
    private VehicleDetailsService vehicleDetailsService;

    public VehicleSteps(VehicleHomePage _vehicleHomePage, VehicleEnquiryPage _vehicleEnquiryPage,
                        ConfirmVehiclePage _confirmVehiclePage){
        vehicleHomePage = _vehicleHomePage;
        vehicleEnquiryPage = _vehicleEnquiryPage;
        confirmVehiclePage = _confirmVehiclePage;
    }

    @Given("^GOV DVLA Platform$")
    public void govDVLAPlatform() throws Throwable {
        vehicleHomePage.assertHomePage();
    }

    @When("^User Trigger Vehicle Enquiry with Registration Number$")
    public void userTriggerVehicleEnquiryWithRegistrationNumber() throws Throwable {
        vehicleHomePage.clickStartNow();
        vehicleEnquiryPage.assertEnquiryPage();
        vehicleEnquiryPage.doVehicleEnquiry(regNum);
    }

    @Then("^Vehicle Details returned in Confirm Vehicle Page$")
    public void vehicleDetailsReturnedInConfirmVehiclePage() throws Throwable {
        confirmVehiclePage.assertConfirmPage();
    }

    @And("^Returned Vehicle Details match Expected Result for Vehicle$")
    public void returnedVehicleDetailsMatchExpectedResultForVehicle() throws Throwable {
        confirmVehiclePage.confirmVehicleDetails(regNum, expVehMake, expVehColour);
    }
}
