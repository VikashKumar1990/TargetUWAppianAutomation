Feature: Login into environment

   @loginAppian
  Scenario: Login into appian using credentials
    Given I open appian login page "https://bpm-uat.targetgroup.corp.local/suite/tempo/news/participating"
    When I enter appian username "VIKASHKUMA" and password "Todayis10%"
    And I click on the appian login button
    Then I should be navigated to appian home page
    
#     @loginAppianBPM
#  Scenario: Login into appianBPM using credentials
#    Given I open appianBPM login page "https://bpm-uat2.targetgroup.corp.local/suite/tempo/"
#    When I enter appianBPM username "VIKASHKUMA" and password "Todayis11%"
#    And I click on the appianBPM login button
#    Then I should be navigated to appianBPM home page
    
     @loginUWUat
  Scenario: Login into UWUat using credentials
    Given I open UWUat login page "https://uat1-servicing.targetgroup.corp.local/SignOnUAT/login.xhtml"
    When I enter UWUat username "VIKASHKUMA" and password "Todayis121%Vikash"
    And I click on the UWUat login button
    Then I should be navigated to UWUat home page
    
    @loginUWST
  Scenario: Login into UWST using credentials
    Given I open UWST login page "https://tst1-servicing.targetgroup.corp.local/SignOnTST/login.xhtml"
    When I enter UWST username "VIKASHKUMA" and password "WelcomeTarget@151"
    And I click on the UWST login button
    Then I should be navigated to UWST home page