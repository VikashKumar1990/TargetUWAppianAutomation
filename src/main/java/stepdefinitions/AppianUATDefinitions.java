package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AppianUATPage;

public class AppianUATDefinitions {
	
	WebDriver driver = Hook.getDriver();
	AppianUATPage appianUATPage = new AppianUATPage(driver);
	
	@When("I click on the Actions tab")
	public void i_click_on_the_actions_tab() {
		appianUATPage.clickOnActionsTab();
	}
	@When("I scroll down and click on Launch Appian Process")
	public void i_scroll_down_and_click_on_launch_appian_process() {
		appianUATPage.clickOnLaunchAppianProcess();
	}
	@When("I select the portfolio name {string} and click on Next")
	public void i_select_the_portfolio_name_and_click_on_next(String portfolioName) {
		appianUATPage.enterPortlioName(portfolioName);
		appianUATPage.clickOnNextButton();
	}
	@When("I enter the account number {string} in the Entity Id field and click on Next")
	public void i_enter_the_account_number_in_the_entity_id_field_and_click_on_next(String entityId) {
		appianUATPage.validateEntityIdPage();
		appianUATPage.enterEntityID(entityId);
		appianUATPage.clickOnNextButton();
	}
	@When("I select worktype {string}, worksubtype {string} and user group {string}")
	public void i_select_worktype_worksubtype_and_user_group(String workType, String workSubType, String userGroup) {
		appianUATPage.validateLaunchPageText();
		appianUATPage.enterWorkTypeOption(workType);
		appianUATPage.selectWorkSubTypeOption(workSubType);
		appianUATPage.selectUserGroupOption(userGroup);
	}
	@When("I enter notes {string} in the Summary Text and Notes field")
	public void i_enter_notes_in_the_summary_text_and_notes_field(String summaryText) {
		appianUATPage.selectSummaryAndNoteField(summaryText);
	}
	@When("I click on Launch Process")
	public void i_click_on_launch_process() {
		appianUATPage.clickOnLauchProcessButton();
	}
	@Then("The Process Launch Confirmation screen should be displayed and closed")
	public void the_process_launch_confirmation_screen_should_be_displayed_and_closed() {
		appianUATPage.validateLaunchProcessConfirmationPage();
	}
	@When("I navigate to the TASK tab")
	public void i_navigate_to_the_task_tab() {
		appianUATPage.clickOnTaskTab();
		appianUATPage.validateTitleTaskPage();
	}
	@When("I open Single Step Tasks")
	public void i_open_single_step_tasks() {
		appianUATPage.clickOnSingleStepLink();
	}
	@When("I click on Show Report Filters")
	public void i_click_on_Show_Report_Filters() {
		appianUATPage.clickOnShowReportFilters();
	}
	@When("I filter with portfolio {string}, worktype {string} and worksubtype {string}")
	public void i_filter_with_portfolio_worktype_and_worksubtype(String portfolio, String workType, String workSubType) {
		appianUATPage.selectReportPortfolio(portfolio);
		appianUATPage.selectReportWorkType(workType);
		appianUATPage.selectReportWorkSubType(workSubType);
		//appianUATPage.selectRecordSingleStepIfTaskNotDisplay();
		
	}
	@Then("The launched process should be displayed as a task")
	public void the_launched_process_should_be_displayed_as_a_task() {
		appianUATPage.validateLatestTaskPresent();
	}
	@When("I select the respective {string} task and click on it")
	public void i_select_the_respective_task_and_click_on_it(String task) {
		appianUATPage.clickOnLatestTaskPresent(task);
	}
	@When("I click on the Accept Task button")
	public void i_click_on_the_accept_task_button() {
		appianUATPage.validateTitleOfSingleStepTaskPage();
		appianUATPage.clickOnAcceptTaskButton();
		appianUATPage.validateTitleOfAcceptTaskPage();
		appianUATPage.clickOnAcceptButton();
	}
	@When("I click on the Complete Task button")
	public void i_click_on_the_complete_task_button() {
		appianUATPage.validateTitleOfSingleStepTaskPage();
		appianUATPage.clickOnCompleteTaskButton();
	}
	@When("I enter notes {string} in the UW Summary Notes field and click on Submit button")
	public void i_enter_notes_in_the_uw_summary_notes_field_and_click_on_submit_button(String subType) {
		appianUATPage.validateTitleOfCompleteTaskPage();
		appianUATPage.selectTheRadioButtonOfActionTaken();
		appianUATPage.enterNoteToAppearInUW(subType);
		appianUATPage.validateNoActionAvailableAfterSubmit();
	}
	@When("I validate the UW home screen is displayed")
	public void i_validate_the_uw_home_screen_is_displayed() {
		appianUATPage.validateTitleOfUWHomePage();
		}
	@When("I click on Chetwood BAU and validate the Chetwood home page is displayed")
	public void i_click_on_chetwood_bau_and_validate_the_chetwood_home_page_is_displayed() throws InterruptedException {
		appianUATPage.clickOnChetwoodBAU();
		appianUATPage.validateTitleOfChetwoodHomePage();
	}
	@When("I enter account number {string} in the Agreement Number field and click on search")
	public void i_enter_account_number_in_the_agreement_number_field_and_click_on_search(String accountNumber) throws InterruptedException {
		appianUATPage.enterAccountNumberInAgreementFieldAndClickOnSearch(accountNumber);
	}
	@When("I click on Account Detail and validate the popup is displayed")
	public void i_click_on_account_detail_and_validate_the_popup_is_displayed() {
		appianUATPage.clickOnAccountDetailAndValidatePopupDisplayed();
	}
	@When("I click on the Verified button and validate the Account Detail home page is displayed")
	public void i_click_on_the_verified_button_and_validate_the_account_detail_home_page_is_displayed() {
		appianUATPage.clickOnVerifiedButtonAndValidateAccountDetailScreen();
	}
	@When("I click on the Diary tab and validate that a new entry is created in the diary {string}")
	public void i_click_on_the_diary_tab_and_validate_that_a_new_entry_is_created_in_the_diary(String accountNumber) throws InterruptedException {
		appianUATPage.clickOnDiaryTab();
		appianUATPage.validateAccountEntryInDiaryTab(accountNumber);
	}
	@When("I logout the UW application")
	public void i_logout_the_uw_application() {
		appianUATPage.clickOnUwLogoutButton();
	}


}
