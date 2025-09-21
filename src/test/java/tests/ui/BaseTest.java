package tests.ui;

import drivers.DriverManager;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import listeners.CustomListener;
import utils.EnvironmentUtils;

import java.io.IOException;

@Listeners({CustomListener.class, io.qameta.allure.testng.AllureTestNg.class})

public class BaseTest {
    // WebDriver instance is protected to be accessible in subclasses and not public
    protected WebDriver driver;


    @BeforeMethod
    // Before each test method, set up the WebDriver
    public void setup() throws IOException {
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestContext context) {
            DriverManager.quitDriver();
    }

    @AfterSuite
    public void openReport() {
        // Skip if running in Headless Mode
        if (EnvironmentUtils.isHeadless()) {
            System.out.println("Reports are blocked in headless mode");
            return;
        }

        System.out.println("I will add a utility to open allure report automatically soon. God willing");
    }
}
