package drivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.EnvironmentUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() throws IOException {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // allow connections from chrome versions that may
            options.addArguments("--remote-allow-origins=*");

            // Fix for user data directory issue
            File tmpProfile = Files.createTempDirectory("chrome-user-data-").toFile();
            options.addArguments("--user-data-dir=" + tmpProfile.getAbsolutePath());

            // Headless mode when specified in cmd prompt
            // use headless mode by adding -Dheadless=true to cmd
            if (EnvironmentUtils.isHeadless()) {
                System.out.println("Headless Mode Activated");

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
