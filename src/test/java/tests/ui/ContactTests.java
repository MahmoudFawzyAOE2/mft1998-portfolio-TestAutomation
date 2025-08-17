package tests.ui;

import listeners.CustomListener;
import pages.*;
import utils.AssertUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testData.URLs;
import utils.DriverUtils;
import utils.RobotUtils;

@Listeners(CustomListener.class)


public class ContactTests extends BaseTest {
    private ContactPage contactPage;
    private AssertUtils assertUtils;
    private DriverUtils driverUtils;
    private RobotUtils robotUtils;

    @BeforeMethod
    public void setUp() {
        // Connect WebDriver from Test with WebDriver from Page
        contactPage = new ContactPage(driver);
        assertUtils = new AssertUtils(driver);
        driverUtils = new DriverUtils(driver);
        robotUtils = new RobotUtils(driver);
    }

    @Test(priority = 1)
    public void verifySuccessfulNavigationToLinkedinProfile() {
        // Navigate to Services page
        driver.navigate().to(URLs.CONTACT_URL);

        // Click on the LinkedIn icon
        contactPage.clickLinkedInIcon();

        // Wait for the LinkedIn link to open in a new tab
        driverUtils.switchToTab(1);

        // Verify that the LinkedIn profile opens in a new tab
        assertUtils.assertURLContains("linkedin");
    }

    @Test(priority = 2)
    public void verifySuccessfulNavigationToGithubProfile() throws InterruptedException {
        // Navigate to Services page
        driver.navigate().to(URLs.CONTACT_URL);

        // Click on the GitHub icon
        contactPage.clickGithubIcon();

        // Switch to the new tab opened by the GitHub link
        driverUtils.switchToTab(1);

        // Verify that the GitHub profile opens in a new tab
        assertUtils.assertURLContains("github");
    }

    /**
    @Test(priority = 3)
    public void verifySuccessfulNavigationToEmail() {
        // Navigate to Services page
        driver.navigate().to(URLs.CONTACT_URL);

        // Click on the Email icon
        contactPage.clickEmailIcon();

        // Wait for the email client to open in a new tab
        driverUtils.switchToTab(1);

        // Verify that the email client opens with the correct email address
        assertUtils.assertURLContains("1998mft1998@gmail.com");
    }
        */

    @Test(priority = 4)
    public void verifySuccessfulNavigationToWhatsApp() throws InterruptedException {
        // Navigate to Services page
        driver.navigate().to(URLs.CONTACT_URL);

        // Click on the WhatsApp icon
        contactPage.clickWhatsAppIcon();

        // Wait for the WhatsApp link to open in a new tab
        driverUtils.switchToTab(1);

        // Press Enter to confirm the WhatsApp popup
        robotUtils.pressEnter();

        // Verify that the WhatsApp chat opens with the correct phone number
        assertUtils.assertURLContains("whatsapp");
    }
}