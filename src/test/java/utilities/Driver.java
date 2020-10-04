package utilities;

import org.openqa.selenium.WebDriver;

public class Driver {
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver get(String browserName) {
        if (driver == null) {
            driver = BrowserFactory.getDriver(browserName);
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
