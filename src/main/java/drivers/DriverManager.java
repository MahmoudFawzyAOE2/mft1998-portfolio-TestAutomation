package drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // allow connections from chrome versions that may
            options.addArguments("--remote-allow-origins=*");

            // Always ensure unique profile directory
            options.addArguments("--user-data-dir="
                    + System.getProperty("java.io.tmpdir")
                    + "/chrome-" + System.currentTimeMillis());

            // Headless mode when specified in cmd prompt
            // use headless mode by adding -Dheadless=true to cmd
            String headless = System.getProperty("headless", "false");
            if (headless.equalsIgnoreCase("true")) {
                // no UI
                options.addArguments("--headless=new");

                // needed to launch chrome on root dir
                options.addArguments("--no-sandbox");

                // disable shared memory usage that may cause crashes
                options.addArguments("--disable-dev-shm-usage");
            }

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
