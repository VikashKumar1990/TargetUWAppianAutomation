Feature: Launch and Verify Appian Process

  @AppianProcess1
Scenario Outline: Launch Appian process and verify Work Type = 'Amend Details' and Work sub-type = 'Letter of Authority'
  Given I open appian login page "https://bpm-uat.targetgroup.corp.local/suite/tempo/news/participating"
  When I enter appian username "VIKASHKUMA" and password "Todayis10%"
  And I click on the appian login button
  Then I should be navigated to appian home page
  When I click on the Actions tab
  And I scroll down and click on Launch Appian Process
  And I select the portfolio name "<portfolio>" and click on Next
  And I enter the account number "<accountNumber>" in the Entity Id field and click on Next
  And I select worktype "<worktype>", worksubtype "<worksubtype>" and user group "<userGroup>"
  And I enter notes "<initialNotes>" in the Summary Text and Notes field
  And I click on Launch Process
  Then The Process Launch Confirmation screen should be displayed and closed
  When I navigate to the TASK tab
  And I open Single Step Tasks
  And I click on Show Report Filters
  And I filter with portfolio "<portfolio>", worktype "<worktype>" and worksubtype "<worksubtype>"
  Then The launched process should be displayed as a task
  When I select the respective "<task>" task and click on it
  And I click on the Accept Task button
  And I click on the Complete Task button
  And I enter notes "<subType>" in the UW Summary Notes field and click on Submit button
  Given I open UWUat login page "https://uat1-servicing.targetgroup.corp.local/SignOnUAT/login.xhtml"
  When I enter UWUat username "VIKASHKUMA" and password "Todayis121%Vikash"
  And I click on the UWUat login button
  And I validate the UW home screen is displayed
  And I click on Chetwood BAU and validate the Chetwood home page is displayed
  And I enter account number "<accountNumber>" in the Agreement Number field and click on search
  And I click on Account Detail and validate the popup is displayed
  And I click on the Verified button and validate the Account Detail home page is displayed
  And I click on the Diary tab and validate that a new entry is created in the diary "<accountNumber>"
  And I logout the UW application

  Examples:
    | portfolio | accountNumber | worktype                    | worksubtype     | userGroup | initialNotes      | subType             | task            |
    | Chetwood  | 120032        | Client Correspondence       | Returned Cheque | CSL1      | Test notes for UW | Customer Management | Returned Cheque |
    
    
@AppianProcess2
Scenario Outline: Launch Appian process and verify Work Type = 'Payment Proposal' and Work sub-type = 'DMP Papers'
  Given I open appian login page "https://bpm-uat.targetgroup.corp.local/suite/tempo/news/participating"
  When I enter appian username "VIKASHKUMA" and password "Todayis10%"
  And I click on the appian login button
  Then I should be navigated to appian home page
  When I click on the Actions tab
  And I scroll down and click on Launch Appian Process
  And I select the portfolio name "<portfolio>" and click on Next
  And I enter the account number "<accountNumber>" in the Entity Id field and click on Next
  And I select worktype "<worktype>", worksubtype "<worksubtype>" and user group "<userGroup>"
  And I enter notes "<initialNotes>" in the Summary Text and Notes field
  And I click on Launch Process
  Then The Process Launch Confirmation screen should be displayed and closed
  When I navigate to the TASK tab
  And I open Single Step Tasks
  And I click on Show Report Filters
  And I filter with portfolio "<portfolio>", worktype "<worktype>" and worksubtype "<worksubtype>"
  Then The launched process should be displayed as a task
  When I select the respective "<task>" task and click on it
  And I click on the Accept Task button
  And I click on the Complete Task button
  And I enter notes "<subType>" in the UW Summary Notes field and click on Submit button
  Given I open UWUat login page "https://uat1-servicing.targetgroup.corp.local/SignOnUAT/login.xhtml"
  When I enter UWUat username "VIKASHKUMA" and password "Todayis121%Vikash"
  And I click on the UWUat login button
  And I validate the UW home screen is displayed
  And I click on Chetwood BAU and validate the Chetwood home page is displayed
  And I enter account number "<accountNumber>" in the Agreement Number field and click on search
  And I click on Account Detail and validate the popup is displayed
  And I click on the Verified button and validate the Account Detail home page is displayed
  And I click on the Diary tab and validate that a new entry is created in the diary "<accountNumber>"
  And I logout the UW application

  Examples:
    | portfolio | accountNumber | worktype                    | worksubtype     | userGroup | initialNotes      | subType             | task       |
    | Chetwood  | 120050        | Payments / Payment Proposal | DMP Papers      | CSL1      | Test notes for UW | Customer Management | DMP Papers |

@AppianProcess3
Scenario Outline: Launch Appian process and verify Work Type = 'Case' and Work sub-type = 'Deed of Postponement (DOP) Case'
  Given I open appian login page "https://bpm-uat.targetgroup.corp.local/suite/tempo/news/participating"
  When I enter appian username "VIKASHKUMA" and password "Todayis10%"
  And I click on the appian login button
  Then I should be navigated to appian home page
  When I click on the Actions tab
  And I scroll down and click on Launch Appian Process
  And I select the portfolio name "<portfolio>" and click on Next
  And I enter the account number "<accountNumber>" in the Entity Id field and click on Next
  And I select worktype "<worktype>", worksubtype "<worksubtype>" and user group "<userGroup>"
  And I enter notes "<initialNotes>" in the Summary Text and Notes field
  And I click on Launch Process
  Then The Process Launch Confirmation screen should be displayed and closed
  When I navigate to the TASK tab
  And I open Single Step Tasks
  And I click on Show Report Filters
  And I filter with portfolio "<portfolio>", worktype "<worktype>" and worksubtype "<worksubtype>"
  Then The launched process should be displayed as a task
  When I select the respective "<task>" task and click on it
  And I click on the Accept Task button
  And I click on the Complete Task button
  And I enter notes "<subType>" in the UW Summary Notes field and click on Submit button
  Given I open UWUat login page "https://uat1-servicing.targetgroup.corp.local/SignOnUAT/login.xhtml"
  When I enter UWUat username "VIKASHKUMA" and password "Todayis121%Vikash"
  And I click on the UWUat login button
  And I validate the UW home screen is displayed
  And I click on Chetwood BAU and validate the Chetwood home page is displayed
  And I enter account number "<accountNumber>" in the Agreement Number field and click on search
  And I click on Account Detail and validate the popup is displayed
  And I click on the Verified button and validate the Account Detail home page is displayed
  And I click on the Diary tab and validate that a new entry is created in the diary "<accountNumber>"
  And I logout the UW application

  Examples:
    | portfolio | accountNumber | worktype | worksubtype                          | userGroup | initialNotes      | subType             | task                            |
    | Chetwood  | 120117        | Case     | Deed of Postponement (DOP) Case      | CSL1      | Test notes for UW | Customer Management | Deed of Postponement (DOP) Case |

@AppianProcess4
Scenario Outline: Launch Appian process and verify Work Type = 'Gone Away Mail' and Work sub-type = 'Address Inaccessible'
  Given I open appian login page "https://bpm-uat.targetgroup.corp.local/suite/tempo/news/participating"
  When I enter appian username "VIKASHKUMA" and password "Todayis10%"
  And I click on the appian login button
  Then I should be navigated to appian home page
  When I click on the Actions tab
  And I scroll down and click on Launch Appian Process
  And I select the portfolio name "<portfolio>" and click on Next
  And I enter the account number "<accountNumber>" in the Entity Id field and click on Next
  And I select worktype "<worktype>", worksubtype "<worksubtype>" and user group "<userGroup>"
  And I enter notes "<initialNotes>" in the Summary Text and Notes field
  And I click on Launch Process
  Then The Process Launch Confirmation screen should be displayed and closed
  When I navigate to the TASK tab
  And I open Single Step Tasks
  And I click on Show Report Filters
  And I filter with portfolio "<portfolio>", worktype "<worktype>" and worksubtype "<worksubtype>"
  Then The launched process should be displayed as a task
  When I select the respective "<task>" task and click on it
  And I click on the Accept Task button
  And I click on the Complete Task button
  And I enter notes "<subType>" in the UW Summary Notes field and click on Submit button
  Given I open UWUat login page "https://uat1-servicing.targetgroup.corp.local/SignOnUAT/login.xhtml"
  When I enter UWUat username "VIKASHKUMA" and password "Todayis121%Vikash"
  And I click on the UWUat login button
  And I validate the UW home screen is displayed
  And I click on Chetwood BAU and validate the Chetwood home page is displayed
  And I enter account number "<accountNumber>" in the Agreement Number field and click on search
  And I click on Account Detail and validate the popup is displayed
  And I click on the Verified button and validate the Account Detail home page is displayed
  And I click on the Diary tab and validate that a new entry is created in the diary "<accountNumber>"
  And I logout the UW application

  Examples:
    | portfolio | accountNumber | worktype       | worksubtype          | userGroup | initialNotes      | subType             | task                 |
    | Chetwood  | 120115        | Gone Away Mail | Address Inaccessible | CSL1      | Test notes for UW | Customer Management | Address Inaccessible |

