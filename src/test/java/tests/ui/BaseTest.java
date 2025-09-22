package tests.ui;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import listeners.CustomListener;
import utils.EnvironmentUtils;

import java.io.IOException;

@Listeners({CustomListener.class, io.qameta.allure.testng.AllureTestNg.class})

public class BaseTest {
    // WebDriver instance is protected to be accessible in subclasses and not public
    protected WebDriver driver;

    @BeforeSuite
    // setup method to initialize WebDriver before any tests run
    /*
    initialization is done once for the entire suite, previously was beforeMethod
    Changed to BeforeSuite to optimize performance by reducing browser restarts
    If tests require fresh browser state, consider using @BeforeMethod instead
    */
    public void setup() throws IOException {
        driver = DriverManager.getDriver();
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @AfterSuite
    public void openReport() {
        // Skip if running in Headless Mode
        if (EnvironmentUtils.isHeadless()) {
            System.out.println("Reports are blocked in headless mode");
            return;
        }

        // Open Allure report Locally using ProcessBuilder
        try {
            System.out.println("Opening Allure report...");
            new ProcessBuilder("cmd", "/c", "allure serve allure-results").start();
            System.out.println("✅ Allure report server started!");
        } catch (IOException e) {
            System.err.println("❌ Failed to open report: " + e.getMessage());
            System.err.println("Make sure Allure CLI is installed: npm install -g allure-commandline");
        }

    }
}
