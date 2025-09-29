package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	private WebDriver driver;
    private WebDriverWait wait;

    public Utils(WebDriver driver) {
    	this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }
    
    public WebElement getLatestTaskDetails(String rowText, int columnIndex) {
        String xpath = String.format(
            "(//table[contains(@class,'PagingGridLayout---table')]//tr[td[normalize-space()='%s']])[last()]//td[%d]",
            rowText, columnIndex
        );
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void clickOnLatestTaskPresent(String rowText, int columnIndex) {
        getLatestTaskDetails(rowText, columnIndex).click();
    }

}
