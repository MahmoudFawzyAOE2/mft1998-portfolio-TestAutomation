package tests.ui;

import drivers.DriverManager;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import listeners.CustomListener;
import utils.EnvironmentUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@Listeners(CustomListener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestContext context) {
        if (CustomListener.testFailed) {
            System.out.println("Test failed. Keeping browser open for debugging.");
        } else {
            DriverManager.quitDriver();
        }
    }

    @AfterSuite
    public void openReport() {
        // Skip if running in Headless Mode
        if (EnvironmentUtils.isHeadless()) {
            System.out.println("Reports are blocked in headless mode");
            return;
        }

        try {
            File htmlFile = new File("test-output/html/index.html");
            if (htmlFile.exists()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Report not found: test-output/html/index.html");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
