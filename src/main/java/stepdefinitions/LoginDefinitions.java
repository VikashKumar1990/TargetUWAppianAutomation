package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginDefinitions {

	WebDriver driver = Hook.getDriver();
	LoginPage loginPage = new LoginPage(driver);

  
  // ---- Appian ----
  @Given("I open appian login page {string}")
  public void iOpenAppianLoginPage(String url) {
      loginPage.openAppian(url);
  }

  @When("I enter appian username {string} and password {string}")
  public void iEnterAppianUsernameAndPassword(String username, String password) {
      loginPage.enterAppianCredentials(username, password);
  }

  @And("I click on the appian login button")
  public void iClickOnTheAppianLoginButton() {
      loginPage.clickAppianLogin();
  }

  @Then("I should be navigated to appian home page")
  public void iShouldBeNavigatedToAppianHomePage() {
      boolean isLogoVisible = loginPage.isAppianLogoDisplayed();
      if (isLogoVisible) {
          System.out.println("Navigated to Appian Home Page successfully, logo is displayed.");
      } else {
          throw new AssertionError("Failed to navigate to Appian Home Page, logo not displayed.");
      }
  }

  // ---- Appian BPM ----
  @Given("I open appianBPM login page {string}")
  public void iOpenAppianBPMLoginPage(String url) {
      loginPage.openAppianBPM(url);
  }

  @When("I enter appianBPM username {string} and password {string}")
  public void iEnterAppianBPMUsernameAndPassword(String username, String password) {
      loginPage.enterAppianBPMCredentials(username, password);
  }

  @And("I click on the appianBPM login button")
  public void iClickOnTheAppianBPMLoginButton() {
      loginPage.clickAppianBPMLogin();
  }

  @Then("I should be navigated to appianBPM home page")
  public void iShouldBeNavigatedToAppianBPMHomePage() {
      System.out.println("Navigated to AppianBPM Home Page");
  }

  // ---- UW UAT ----
  @Given("I open UWUat login page {string}")
  public void iOpenUWUatLoginPage(String url) {
      loginPage.openUWUAT(url);
  }

  @When("I enter UWUat username {string} and password {string}")
  public void iEnterUWUatUsernameAndPassword(String username, String password) {
      loginPage.enterUWUATCredentials(username, password);
  }

  @And("I click on the UWUat login button")
  public void iClickOnTheUWUatLoginButton() {
      loginPage.clickUWUATLogin();
  }

  @Then("I should be navigated to UWUat home page")
  public void iShouldBeNavigatedToUWUatHomePage() {
      System.out.println("Navigated to UWUat Home Page");
  }

  // ---- UW ST ----
  @Given("I open UWST login page {string}")
  public void iOpenUWSTLoginPage(String url) {
      loginPage.openUWST(url);
  }

  @When("I enter UWST username {string} and password {string}")
  public void iEnterUWSTUsernameAndPassword(String username, String password) {
      loginPage.enterUWSTCredentials(username, password);
  }

  @And("I click on the UWST login button")
  public void iClickOnTheUWSTLoginButton() {
      loginPage.clickUWSTLogin();
  }

  @Then("I should be navigated to UWST home page")
  public void iShouldBeNavigatedToUWSTHomePage() {
      System.out.println("Navigated to UWST Home Page");
  }
  
}
