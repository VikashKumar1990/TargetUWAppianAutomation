package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppianUATPage extends Base {
	
    //WebDriver driver ; 
	private WebDriver driver;
    private Utils util;
	
//	public AppianUATPage(WebDriver driver) {
//        this.driver = driver;
//    }
	public AppianUATPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
        PageFactory.initElements(driver, this);
        this.util = new Utils(driver); 
    }
	
	//Utils util = new Utils(driver);
	
	@FindBy(xpath = "//*[@id=\"navBarTabs\"]/li[@title='Actions']//div[text()='Actions']")
    private WebElement actionsTab;
	
	@FindBy(xpath = "//div[@class='aui-Action']//a[text()='Launch Appian Process']")
    private WebElement launchAppianProcess;
	
	@FindBy(xpath = "//div//h1[text()='Select Portfolio To Launch Process For']")
    private WebElement launchAppianPageHandline;
	
	@FindBy(xpath = "//*[@id=\"28f8ef3ab5eb9186948fa0f098087c9f_value\"]")
    private WebElement portfolioDropdown;
	
	@FindBy(xpath = "//*[@id=\"28f8ef3ab5eb9186948fa0f098087c9f_value\"]//span[text()='Chetwood']")
    private WebElement optionChetwood;
	
	@FindBy(xpath = "//button[text()='Next']")
    private WebElement NextButton;
	
	@FindBy(xpath = "//div[@id='sitesBody']//h1[text()='Enter Entity Id']")
    private WebElement EntityIdText;
	
	@FindBy(xpath = "//*[@id=\"2a6bf670747a3dcc438d25ddda88c503\"]")
    private WebElement EntityIdTextField;
	
	@FindBy(xpath = "//div[@id='sitesBody']//h1[text()='Select Process To Launch']")
    private WebElement LaunchPageText;
	
	@FindBy(xpath = "//span[normalize-space()='Work Type']/parent::div/following::div[@role='combobox'][1]")
    private WebElement workTypedropdown;
	
	@FindBy(xpath = "//span[normalize-space()='Work Subtype']/parent::div/following::div[@role='combobox'][1]")
    private WebElement workSubTypedropdown;
	
	@FindBy(xpath = "//span[normalize-space()='User Group']/parent::div/following::div[@role='combobox'][1]")
    private WebElement userGroupDropdown;
	
	@FindBy(css = "#\\39 52dcf6c7c900e7a49777b261dc5c4c9")
    private WebElement summayTextField;
	
	@FindBy(css = "#\\30 8985e807c4b947b879d1cb47e0ce2a3")
    private WebElement noteField;
	
	@FindBy(xpath = "//button[@type='button' and text()='Launch Process']")
    private WebElement launchProcessButton;
	
	@FindBy(xpath = "//button[@type='button' and text()='Close']")
    private WebElement closeButton;
	
	@FindBy(xpath = "//ul[@id='navBarTabs']//li[following-sibling::li]//a//div[contains(text(),'Task')]")
    private WebElement taskTab;
	
	@FindBy(xpath = "//*[@class='viewgroup appian-gwt-filters']/li[25]//a")
    private WebElement singleStepLink;
	
	@FindBy(xpath = "//*[@data-testid=\"SectionLayout2-contentContainer\"]//div//p//a[contains(text(),'Show Report Filters')]")
    private WebElement showReportFilters;
	
	@FindBy(xpath = "//span[normalize-space()='Portfolio']/parent::div/following::div[@role='combobox'][1]")
    private WebElement reportPortfolioDropdown;
	
	@FindBy(xpath = "//span[normalize-space()='Work Type']/parent::div/following::div[@role='combobox'][1]")
    private WebElement reportWorkTypeDropdown;
	
	@FindBy(xpath = "//span[normalize-space()='Work Sub-Type']/parent::div/following::div[@role='combobox'][1]")
    private WebElement reportWorkSubTypeDropdown;
	
	@FindBy(xpath = "//div[@data-testid='SectionLayout2-contentContainer']//div//span[contains(text(),'There are no tasks or processes')]")
    private WebElement NoTaskTextMessage;
	
	@FindBy(xpath = "//ul[@id='navBarTabs']//li[following-sibling::li]//a//div[contains(text(),'Records')]")
    private WebElement recordTab;
	
	@FindBy(xpath = "//div[@data-testid='CardLayout-cardDiv' and @title='Single Step Tasks - List of single step tasks.']")
    private WebElement singleStepTaskOnRecord;
	
//	@FindBy(xpath = "(//table[contains(@class,'PagingGridLayout---table')]//tr[td[normalize-space()='Returned Cheque']])[last()]//td[1]")
//    private WebElement latestTaskDetails;
	
	@FindBy(xpath = "//table[contains(@class,'PagingGridLayout---table')]//tbody[1]//tr[1]")
    private WebElement latestTaskDetails;

	@FindBy(xpath = "//button[text()='Accept Task']")
    private WebElement acceptTaskButton;
	
	@FindBy(xpath = "//button[text()='Accept']")
    private WebElement acceptButton;
	
	@FindBy(xpath = "//button[text()='Complete Task']")
    private WebElement completeTaskButton;
	
	@FindBy(xpath = "//span[normalize-space()='Sub Type']/parent::div/following::div[@role='combobox'][1]")
    private WebElement subTypeDropdown;
	
	@FindBy(xpath = "//label[normalize-space()='Summary']/parent::div/following::input[@type='text']")
    private WebElement summaryUWText;
	
	@FindBy(xpath = "//label[normalize-space()='Detail']/following::textarea[1]")
    private WebElement detailTextBox;
	
	@FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;
	
	@FindBy(xpath = "//div[@id='sitesBody']//p[contains(text(),'No actions available')]")
    private WebElement noActionAvailableMessage;
	
	@FindBy(xpath = "//div[contains(@class,'tab_label') and normalize-space()='Summary']")
    private WebElement summaryTab;
	
	@FindBy(xpath = "//table[@id='workbenchPanel:j_id60:6:applications']//a")
    private WebElement chetwoodBau;
	
	@FindBy(xpath = "//td[normalize-space(text())='Agreement No.']/following-sibling::td//input")
    private WebElement agreementNumberField;
	
	@FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='tableContainer']//tbody")
    private WebElement accountDetail;
	
	@FindBy(xpath = "//div[@class='popupContainer']//table//tr//td//button[text()='Verified']")
    private WebElement verifiedButtonInPopup;
	
	@FindBy(xpath = "(//tr[@class='tabRow']//li[@title='Diary']//span[normalize-space(text())='Diary'])[1]")
    private WebElement diaryTab;
	
	@FindBy(xpath = "//table[@id='CustomerDiary']//tbody//tr[1]//td[2]")
    private WebElement latestAccountEntryInDiary;
	
	@FindBy(xpath = "//div[@class='buttonBar']//span[normalize-space(.)='Logout']")
    private WebElement uwLogoutButton;
	
	public void clickOnActionsTab() {
		waitForVisibility(actionsTab,10);
		clickOn(actionsTab);
	}
	
	public void clickOnLaunchAppianProcess() {
		waitForVisibility(launchAppianProcess,10);
		clickOn(launchAppianProcess);
		if (validateElementText(launchAppianPageHandline, "Select Portfolio To Launch Process For", 10)) {
		    System.out.println("Nevigated correct page");
		} else {
		    System.out.println("Nevigated wrong page");
		}
	}
	
	public void clickOnDropdown() {
		clickOn(portfolioDropdown);
	}
	public void enterPortlioName(String portfolioName) {
		selectDropdownOption(portfolioDropdown,portfolioName);
	}
	public void clickOnNextButton() {
		clickOn(NextButton);
	}
	public void validateEntityIdPage() {
		validateElementText(EntityIdText, "Enter Entity Id" , 10);
	}
	public void enterEntityID(String entityID) {
		enterText(EntityIdTextField,entityID);
	}
	public void validateLaunchPageText() {
		validateElementText(LaunchPageText, "Select Process To Launch" , 10);
	}
	public void enterWorkTypeOption(String workTypeOption)  {
		selectDropdownOption(workTypedropdown,workTypeOption);
	}
	public void selectWorkSubTypeOption(String workSubTypeOption) {
		selectDropdownOption(workSubTypedropdown,workSubTypeOption);
	}
	public void selectUserGroupOption(String userGroupOption) {
		selectDropdownOption(userGroupDropdown,userGroupOption);
	}
	public void selectSummaryAndNoteField(String summaryText) {
		enterText(summayTextField,summaryText);
		enterText(noteField,"Testing");
	}
	public void clickOnLauchProcessButton() {
		clickOn(launchProcessButton);
	}
	public void validateLaunchProcessConfirmationPage() {
		validatePageTitle("Confirmation",10);
	}
	public void clickOnCloseButton() {
		clickOn(closeButton);
	}
	public void clickOnTaskTab() {
		clickOn(taskTab);
	}
	public void validateTitleTaskPage() {
		validatePageTitle("Tasks",10);
	}
	public void clickOnSingleStepLink() {
		clickOn(singleStepLink);
	}
	public void clickOnShowReportFilters() {
		clickOn(showReportFilters);
	}
	public void selectReportPortfolio(String portfolio) {
		selectDropdownOption(reportPortfolioDropdown,portfolio);
	}
	public void selectReportWorkType(String workType) {
		selectDropdownOption(reportWorkTypeDropdown,workType);
	}
	public void selectReportWorkSubType(String workSubType) {
		selectDropdownOption(reportWorkSubTypeDropdown,workSubType);
	}
	public void selectRecordSingleStepIfTaskNotDisplay() {
		if(NoTaskTextMessage.isDisplayed()) {
			clickOn(recordTab);
			validatePageTitle("Records",10);
			clickOn(singleStepTaskOnRecord);
			// Need to write few more code
		}else {
		    // If element is NOT present, just skip and continue
		    System.out.println("NoTaskTextMessage not found, skipping and continuing with next steps...");
		}
	}
	public void validateLatestTaskPresent() {
		//isElementPresent(latestTaskDetails);
		latestTaskDetails.isDisplayed();
	}
	public void clickOnLatestTaskPresent(String task) {
		//clickOn(latestTaskDetails);
		util.clickOnLatestTaskPresent(task, 1);
	}
	public void validateTitleOfSingleStepTaskPage() {
		validatePageTitleContains("Single Step : Account" , 20);
	}
	public void clickOnAcceptTaskButton() {
		clickOn(acceptTaskButton);
	}
	public void validateTitleOfAcceptTaskPage() {
		validatePageTitle("Accept Task",10);
	}
	public void clickOnAcceptButton() {
		clickOn(acceptButton);
	}
	public void clickOnCompleteTaskButton() {
		clickOn(completeTaskButton);
	}
	public void validateTitleOfCompleteTaskPage() {
		validatePageTitle("Complete Task",10);
	}
	public void selectTheRadioButtonOfActionTaken() {
		selectRadioButtonByLabel("Task has been completed with instruction(s) carried out successfully");
	}
	public void enterNoteToAppearInUW(String subType) {
		selectDropdownOption(subTypeDropdown,subType);
		enterText(summaryUWText,"Appian");
		enterText(detailTextBox,"Appian-Returned Cheque");
		clickOn(submitButton);
	}
	public void validateNoActionAvailableAfterSubmit() {
		validateElementText(summaryTab, "Summary", 20);
	}
	public void validateTitleOfUWHomePage() {
		validatePageTitleContains("Single Sign On" , 20);
	}
	public void clickOnChetwoodBAU() throws InterruptedException {
		clickOn(chetwoodBau);
		Thread.sleep(10000);
	}
	public void validateTitleOfChetwoodHomePage() {
		switchToNewTab();
		validatePageTitleContains("Chetwood - Universal Workspace" , 20);
	}
	public void enterAccountNumberInAgreementFieldAndClickOnSearch(String accountNumber) throws InterruptedException {
		enterText(agreementNumberField,accountNumber);
		Thread.sleep(10000);
		clickOn(searchButton);
		Thread.sleep(10000);
		//activeFieldOnPage(accountNumber);
		//Thread.sleep(10000);
		//searchButton.submit();
	}
	public void clickOnAccountDetailAndValidatePopupDisplayed() {
		clickOn(accountDetail);
		//switchToAlert(10);
		switchToFrame("_iframe-popupWindow");
		validateElementText(verifiedButtonInPopup, "Verified", 20);
	}
	public void clickOnVerifiedButtonAndValidateAccountDetailScreen() {
		//switchToAlert(10);
		clickOn(verifiedButtonInPopup);
		validatePageTitleContains("Chetwood - Universal Workspace" , 20);
	}
	public void clickOnDiaryTab() throws InterruptedException {
		//clickOn(diaryTab);
		switchToDefaultContent();
		hoverAndClick(diaryTab);
		Thread.sleep(10000);
	}
	public void validateAccountEntryInDiaryTab(String expectedAccount) {
		String actualAccount = extractTrimmedNumber(latestAccountEntryInDiary, 3);
		if(actualAccount.equalsIgnoreCase(expectedAccount)) {
			System.out.println("Account entry is available in Diary");
		}else {
			System.out.println("Account entry is not available");
		}
	}
	public void clickOnUwLogoutButton() {
		clickOn(uwLogoutButton);
	}
	
}
