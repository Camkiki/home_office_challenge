package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.BasePage;

/**
 * Created by tolaf on 02/05/2018.
 *
 */
public class Hooks {
    private String baseURL = "https://www.gov.uk/get-vehicle-information-from-dvla";
    private String browser = "chrome";
    private BasePage basePage;

    public Hooks(BasePage basePage){
        this.basePage =basePage;
    }

    @Before
    public void setUp(){
        basePage.openBrowser(browser);
        basePage.navigateToURL(baseURL);
        basePage.applyWaits();
    }

    @After
    public void  tearDown(){
        basePage.closeBrowser();
    }
}
