package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by tolaf on 01/05/2018.
 * superclass with WebDriver and WebElement Extensions
 */
public class BasePage {
    private static final long DRIVER_WAIT_TIME = 10;
    private static WebDriver webDriver = null;

    private String driverFolder="/HomeOfficeAutomationFramework/HomeOfficeChallenge/src/test/java/drivers";

    public BasePage(){
        PageFactory.initElements(webDriver, this);
    }

    public void openBrowser(String browser) {

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverFolder.concat("/chromedriver.exe"));
            webDriver = new ChromeDriver();

        } else if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", driverFolder.concat("/IEDriverServer.exe"));
            webDriver = new InternetExplorerDriver();

        } else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", driverFolder.concat("/geckodriver.exe"));
            webDriver = new FirefoxDriver();
        }
    }

    public void navigateToURL(String url){
        webDriver.get(url);
    }

    public void applyWaits(){
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void maximizeWindow(){
        webDriver.manage().window().maximize();
    }

    public void closeBrowser() {
        webDriver.quit();
    }

    public String getCurrentPageTitle() {
        return webDriver.getTitle();
    }

    public void shouldBeVisible(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(webDriver, DRIVER_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void clickOnButton(WebElement webElement) {
        shouldBeVisible(webElement);
        webElement.click();
    }

    public void enterValue(WebElement webElement, String value) {
        shouldBeVisible(webElement);
        webElement.clear();
        webElement.sendKeys(value);
    }

    public String getText(WebElement webElement){
        shouldBeVisible(webElement);
        return webElement.getText();
    }

}
