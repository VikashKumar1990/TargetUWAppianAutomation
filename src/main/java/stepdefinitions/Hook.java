package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;

//import static util.ConfigReader.getAppianUrl;

import io.cucumber.java.AfterStep;
import java.io.File;
import java.nio.file.Files;
import org.openqa.selenium.*;
import io.cucumber.java.Scenario;

public class Hook {

    public static WebDriver driver;
    
    @Before
    public void openBrowser() throws IOException {
    	System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
	@After
    public void closeBrowser(){
    	 if (driver != null) {
             driver.quit();  // better than close()
         }
    }
	
	@AfterStep
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {  // change to `true` if you want screenshot for every step
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);

                // Attach screenshot in cucumber report
                scenario.attach(src, "imagefailed/png", "Failed Step Screenshot");

                // Save screenshot to target/screenshots folder for Extent
                File srcFile = ts.getScreenshotAs(OutputType.FILE);
                String screenshotDir = "target/screenshots/";
                File destFile = new File(screenshotDir + scenario.getName().replaceAll(" ", "_") + ".png");
                destFile.getParentFile().mkdirs(); // create folder if not exists
                Files.copy(srcFile.toPath(), destFile.toPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
        	TakesScreenshot ts = (TakesScreenshot) Hook.driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            // Attach screenshot to Cucumber report
            scenario.attach(screenshot, "imagepassed/png", "Step Screenshot");
        }
    }
	
    public static WebDriver getDriver(){
        return driver;
    }
}
