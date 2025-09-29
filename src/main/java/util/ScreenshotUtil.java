package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import java.io.File;

public class ScreenshotUtil {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "target/screenshots/" + screenshotName + ".png";
            File dest = new File(path);

            // create directory if it doesn't exist
            dest.getParentFile().mkdirs();

            FileUtils.copyFile(src, dest);
            return dest.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
