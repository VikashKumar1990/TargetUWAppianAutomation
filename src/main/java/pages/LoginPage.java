package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage extends Base {
	
	WebDriver driver ; 
	
	public LoginPage(WebDriver driver) {
		super(driver);
        this.driver = driver;
    }
	
	
	// ====== Appian Locators ======
    private By appianUsername = By.xpath("//input[@id='un']");
    private By appianPassword = By.xpath("//input[@id='pw']");
    private By appianLoginBtn = By.xpath("//input[@type='submit']");
    
    // ====== AppianBPM Locators ======
    private By appianBPMUsername = By.id("j_username");
    private By appianBPMPassword = By.id("j_password");
    private By appianBPMLoginBtn = By.id("loginBtn");

    // ====== UWUAT Locators ======
    private By uwUATUsername = By.xpath("//input[@id='j_username']");     
    private By uwUATPassword = By.xpath("//input[@id='j_password']");
    private By uwUATLoginBtn = By.id("j_id26");

    // ====== UWST Locators ======
    private By uwSTUsername = By.xpath("//input[@id='j_username']");      
    private By uwSTPassword = By.xpath("//input[@id='j_password']");
    private By uwSTLoginBtn = By.id("j_id26");

 
    // ================== APPiAN ==================
    public void openAppian(String url) {
        driver.get(url);
    }

    public void enterAppianCredentials(String username, String password) {
        driver.findElement(appianUsername).clear();
        driver.findElement(appianUsername).sendKeys(username);
        driver.findElement(appianPassword).clear();
        driver.findElement(appianPassword).sendKeys(password);
    }

    public void clickAppianLogin() {
        driver.findElement(appianLoginBtn).click();
    }
    
    public boolean isAppianLogoDisplayed() {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, 20); // 20 sec timeout
            wait.until(ExpectedConditions.titleContains("News"));
            String title = driver.getTitle();
            System.out.println("Page title is: " + title);
            return title.contains("News");
        } catch (Exception e) {
            return false;
        }
    }
    

    // ================== APPiAN BPM ==================
    public void openAppianBPM(String url) {
        driver.get(url);
    }

    public void enterAppianBPMCredentials(String username, String password) {
        driver.findElement(appianBPMUsername).clear();
        driver.findElement(appianBPMUsername).sendKeys(username);
        driver.findElement(appianBPMPassword).clear();
        driver.findElement(appianBPMPassword).sendKeys(password);
    }

    public void clickAppianBPMLogin() {
        driver.findElement(appianLoginBtn).click();
    }

    // ================== UW UAT ==================
    public void openUWUAT(String url) {
        driver.get(url);
    }

    public void enterUWUATCredentials(String username, String password) {
        driver.findElement(uwUATUsername).clear();
        driver.findElement(uwUATUsername).sendKeys(username);
        driver.findElement(uwUATPassword).clear();
        driver.findElement(uwUATPassword).sendKeys(password);
    }

    public void clickUWUATLogin() {
        driver.findElement(uwUATLoginBtn).click();
    }

    // ================== UW ST ==================
    public void openUWST(String url) {
        driver.get(url);
    }

    public void enterUWSTCredentials(String username, String password) {
        driver.findElement(uwSTUsername).clear();
        driver.findElement(uwSTUsername).sendKeys(username);
        driver.findElement(uwSTPassword).clear();
        driver.findElement(uwSTPassword).sendKeys(password);
    }

    public void clickUWSTLogin() {
        driver.findElement(uwSTLoginBtn).click();
    }


}
