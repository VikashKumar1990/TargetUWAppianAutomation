package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static stepdefinitions.Hook.driver;
import static stepdefinitions.Hook.getDriver;

public class Base {
	
	
	protected WebDriver driver;
	private WebDriverWait wait;

    // Constructor
    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }
    
    //Validate Page title
    public boolean validatePageTitle(String expectedTitlePart, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
            wait.until(ExpectedConditions.titleContains(expectedTitlePart));

            String actualTitle = driver.getTitle();
            System.out.println("Current Page Title: " + actualTitle);

            return actualTitle.contains(expectedTitlePart);
        } catch (Exception e) {
            System.out.println("Page title validation failed: " + e.getMessage());
            return false;
        }
    }
    // Validate dynamic title with help of contains method
    public void validatePageTitleContains(String expectedTitlePart, int timeoutInSeconds) {
        try {
            // Wait until title contains the expected text
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(ExpectedConditions.titleContains(expectedTitlePart));

            String actualTitle = driver.getTitle();
            if (actualTitle.contains(expectedTitlePart)) {
                System.out.println("Page title validation passed. Expected part: '" 
                                   + expectedTitlePart + "', Actual title: " + actualTitle);
            } else {
                throw new RuntimeException("Page title validation failed. Expected part: '" 
                                           + expectedTitlePart + "', Actual: " + actualTitle);
            }
        } catch (TimeoutException e) {
            throw new RuntimeException("Page title did not contain '" + expectedTitlePart 
                                       + "' within " + timeoutInSeconds + " seconds");
        }
    }

    //Validate Element text on page
    public boolean validateElementText(WebElement element, String expectedText, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
            // Wait until the element contains the expected text
            wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));

            String actualText = element.getText().trim();
            System.out.println("Actual Text: " + actualText);

            return actualText.contains(expectedText);
        } catch (Exception e) {
            System.out.println("Text validation failed: " + e.getMessage());
            return false;
        }
    }

  // Wait for visibility of element
  public WebElement waitForVisibility(WebElement element, int timeout) {
	    return new WebDriverWait(driver, timeout)
	            .until(ExpectedConditions.visibilityOf(element));
	}
  
  //To click on Element
  public void clickOn(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, 20); // wait up to 10s
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
	}
  //Click using Actions class
  public void clickTabUsingActions(WebElement element) {
	    try {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).click().perform();
	        System.out.println("Clicked on tab using Actions: " + element);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to click on tab using Actions: " + e.getMessage(), e);
	    }
	}
  // Move the cursur and click
  public void hoverAndClick(WebElement element) {
	    try {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).pause(500).click().perform();
	        System.out.println("Hovered and clicked on element: " + element);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to hover & click: " + e.getMessage(), e);
	    }
	}
  
  //enter the text in textbox
  public void enterText(WebElement element, String text) {
	    try {
	        element.clear(); // clear existing text
	        element.sendKeys(text);
	        System.out.println("Entered text: " + text);
	    } catch (Exception e) {
	        System.out.println("Failed to enter text: " + e.getMessage());
	    }
	}
  
  // Select the radio button using label
  public void selectRadioButtonByLabel(String labelText) {
	    try {
	        WebElement radio = driver.findElement(By.xpath("//label[contains(text(),'" + labelText + "')]"));
	        radio.click();
	        System.out.println("Selected radio button with label: " + labelText);
	    } catch (Exception e) {
	        throw new RuntimeException("Radio button with label '" + labelText + "' not found", e);
	    }
	}
  
  //Generic Method for Non-<select> Dropdowns
  public void selectCustomDropdownOption(List<WebElement> options, String expectedText) {
      try {
          for (WebElement option : options) {
              if (option.getText().trim().equalsIgnoreCase(expectedText)) {
                  option.click();
                  System.out.println("Selected option: " + expectedText);
                  return;
              }
          }
          System.out.println("Option not found: " + expectedText);
      } catch (Exception e) {
          System.out.println("Dropdown selection failed: " + e.getMessage());
      }
  }
  
  // If dropdown devloped using select tag
  public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
	    try {
	        Select select = new Select(dropdownElement);
	        select.selectByVisibleText(visibleText);
	        System.out.println("Selected option by visible text: " + visibleText);
	    } catch (Exception e) {
	        System.out.println("Dropdown selection failed: " + e.getMessage());
	    }
	}

	public void selectDropdownByValue(WebElement dropdownElement, String value) {
	    try {
	        Select select = new Select(dropdownElement);
	        select.selectByValue(value);
	        System.out.println("Selected option by value: " + value);
	    } catch (Exception e) {
	        System.out.println("Dropdown selection failed: " + e.getMessage());
	    }
	}

	public void selectDropdownByIndex(WebElement dropdownElement, int index) {
	    try {
	        Select select = new Select(dropdownElement);
	        select.selectByIndex(index);
	        System.out.println("Selected option by index: " + index);
	    } catch (Exception e) {
	        System.out.println("Dropdown selection failed: " + e.getMessage());
	    }
	}
	// Switch to frame using WebElement
    public void switchToFrame(By frameLocator) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
            System.out.println("Switched to frame: " + frameLocator.toString());
        } catch (Exception e) {
            System.out.println("Failed to switch to frame: " + frameLocator.toString());
            e.printStackTrace();
        }
    }

    // Switch to frame by index
    public void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
            System.out.println("Switched to frame index: " + index);
        } catch (Exception e) {
            System.out.println("Failed to switch to frame index: " + index);
            e.printStackTrace();
        }
    }

    // witch to frame by name/id
    public void switchToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
            System.out.println("Switched to frame: " + nameOrId);
        } catch (Exception e) {
            System.out.println("Failed to switch to frame: " + nameOrId);
            e.printStackTrace();
        }
    }

    // Switch back to main page
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main page (default content)");
    }
	
     // Check if element is present (without throwing exception)
    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
	
	public boolean selectDropdownOption(WebElement dropdown, String optionText) {
        optionText = optionText == null ? "" : optionText.trim();
        try {
            // 1) Open the dropdown (normal click, fallback to JS)
            try {
                wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
            } catch (Exception openEx) {
                // fallback: attempt JS click
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
                } catch (Exception jsOpenEx) {
                    System.out.println("Unable to open dropdown by click or JS: " + jsOpenEx.getMessage());
                }
            }

            // 2) Wait for options to appear - try multiple likely XPaths
            String[] candidateOptionXpaths = new String[] {
                "//div[@role='option']",
                "//li[@role='option']",
                "//div[contains(@class,'option')]",        // generic fallback
                "//div[contains(@class,'Option')]",        // another variant
                "//ul//li"                                 // very generic
            };

            List<WebElement> options = null;
            for (String xp : candidateOptionXpaths) {
                try {
                    options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xp)));
                    if (options != null && options.size() > 0) {
                        // found candidate options
                        break;
                    }
                } catch (Exception e) {
                    // ignore and try next xpath
                }
            }

            if (options == null || options.isEmpty()) {
                // final attempt: look for any descendant elements with role attribute
                try {
                    options = driver.findElements(By.xpath("//*[(@role='option' or @role='menuitem') and string-length(normalize-space(.))>0]"));
                } catch (Exception e) {
                    // ignore
                }
            }

            if (options == null || options.isEmpty()) {
                System.out.println("No dropdown options found after opening the dropdown.");
                return false;
            }

            // Debug: print all option texts
            System.out.println("DEBUG: Found options (" + options.size() + "):");
            for (WebElement opt : options) {
                try {
                    System.out.println("  -> '" + opt.getText().trim() + "'");
                } catch (Exception ignore) { }
            }

            // 3) Try to find exact match, then contains (case-insensitive)
            WebElement match = null;
            for (WebElement opt : options) {
                String txt = "";
                try { txt = opt.getText().trim(); } catch (Exception ignore) {}
                if (!txt.isEmpty() && txt.equalsIgnoreCase(optionText)) {
                    match = opt;
                    break;
                }
            }
            if (match == null) {
                for (WebElement opt : options) {
                    String txt = "";
                    try { txt = opt.getText().trim(); } catch (Exception ignore) {}
                    if (!txt.isEmpty() && txt.toLowerCase().contains(optionText.toLowerCase())) {
                        match = opt;
                        break;
                    }
                }
            }

            // 4) If still not found, try a dynamic xpath searching for text in options container
            if (match == null) {
                try {
                    String xpathContaining = String.format("//*[(@role='option' or @role='menuitem') and contains(normalize-space(.),'%s')]", optionText);
                    match = driver.findElement(By.xpath(xpathContaining));
                } catch (Exception e) {
                    // ignore
                }
            }

            if (match == null) {
                System.out.println("No matching option found for: '" + optionText + "'");
                return false;
            }

            // 5) Try to click the matched option (regular click, JS click, Actions)
            try {
                wait.until(ExpectedConditions.elementToBeClickable(match)).click();
                System.out.println("Clicked option by normal click: " + optionText);
                return true;
            } catch (Exception clickEx) {
                try {
                    // scroll into view + JS click
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", match);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", match);
                    System.out.println("Clicked option by JS click: " + optionText);
                    return true;
                } catch (Exception jsClickEx) {
                    try {
                        // Actions moveToElement click
                        new Actions(driver).moveToElement(match).click().perform();
                        System.out.println("Clicked option by Actions click: " + optionText);
                        return true;
                    } catch (Exception actionsEx) {
                        System.out.println("All click attempts failed for option: " + optionText);
                        actionsEx.printStackTrace();
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Unexpected error while selecting dropdown option '" + optionText + "': " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
	
	// Remove the 0 & 001 from agreement number
	public String extractTrimmedNumber(WebElement element, int trimDigits) {
	    // Step 1: Get text from the element
	    String rawValue = element.getText().trim();
	    if (rawValue.isEmpty()) {
	        rawValue = element.getAttribute("value"); // fallback if it's an input field
	    }
	    // Step 2: Remove leading zeros
	    String withoutLeadingZeros = rawValue.replaceFirst("^0+", "");
	    // Step 3: Remove last N digits safely
	    if (withoutLeadingZeros.length() > trimDigits) {
	        withoutLeadingZeros = withoutLeadingZeros.substring(0, withoutLeadingZeros.length() - trimDigits);
	    } else {
	        throw new RuntimeException("Number length is too short to trim " + trimDigits + " digits.");
	    }

	    System.out.println("Extracted Number: " + withoutLeadingZeros);
	    return withoutLeadingZeros;
	}
	// enter the element in active field
	public void activeFieldOnPage(String accountNumber) {
        WebElement activeField = driver.switchTo().activeElement();
        activeField.clear();
        activeField.sendKeys(accountNumber);
    }
	
	//Switch to tab by index (0 = first tab)
    public static void switchToTabByIndex(WebDriver driver, int index) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        if (index < windowHandles.size()) {
            driver.switchTo().window(windowHandles.get(index));
        } else {
            throw new IllegalArgumentException("Invalid tab index: " + index);
        }
    }

     //Switch to the newest (last opened) tab
    public void switchToNewTab() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized!");
        }

        // wait until at least 2 tabs are open
        WebDriverWait wait = new WebDriverWait(driver, 10); 
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
    }

     //Switch back to the parent (first) tab 
    public static void switchToParentTab(WebDriver driver) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(0));
    }

     //Switch to tab containing part of a title 
    public static void switchToTabByTitle(WebDriver driver, String partialTitle) {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(partialTitle)) {
                return;
            }
        }
        throw new NoSuchWindowException("No tab found with title containing: " + partialTitle);
    }
    // Handle popup
    public Alert switchToAlert(int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds);
            wait.until(ExpectedConditions.alertIsPresent());
            
            Alert alert = driver.switchTo().alert();
            System.out.println("Popup detected with text: " + alert.getText());
            return alert;  // return control to caller
        } catch (TimeoutException e) {
            throw new RuntimeException("No alert popup appeared within " + timeoutSeconds + " seconds", e);
        }
    }
}
