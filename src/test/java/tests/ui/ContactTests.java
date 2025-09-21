package tests.ui;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pages.ContactPage;
import pages.components.Toast;
import testData.TestData;
import utils.AssertUtils;
import org.testng.annotations.Test;
import testData.URLs;
import utils.DriverUtils;

public class ContactTests extends BaseTest {
    private ContactPage contactPage;
    private AssertUtils assertUtils;
    private DriverUtils driverUtils;
    private Toast toast;

    @BeforeClass
    public void setUp() {
        // Create Objects form Pages to connect WebDriver from Test with WebDriver from Page
        contactPage = new ContactPage(driver);
        toast = new Toast(driver);
        assertUtils = new AssertUtils(driver);
        driverUtils = new DriverUtils(driver);
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

    @Test(priority = 3)
    public void verifySuccessfulNavigationToWhatsApp() throws InterruptedException {
        // Navigate to Services page
        driver.navigate().to(URLs.CONTACT_URL);

        // Click on the WhatsApp icon
        contactPage.clickWhatsAppIcon();

        // Wait for the WhatsApp link to open in a new tab
        driverUtils.switchToTab(1);

        // Verify that the WhatsApp chat opens with the correct phone number
        assertUtils.assertURLContains("whatsapp");
    }

    @DataProvider(name = "contactFormData")
    public static Object[][] provideContactFormData() {
        return new Object[][] {
                { TestData.NAME, TestData.EMAIL, TestData.SUBJECT, TestData.MESSAGE }
        };
    }
    // this test was removed from TestNG.xml due to FormSpree limitations
    @Test(priority = 4, dataProvider = "contactFormData")
    public void verifyVisitorCanSendAnEmailViaForm(String name, String email, String subject, String message) {
        // Navigate to Services page
        driver.navigate().to(URLs.CONTACT_URL);

        // Fill out the contact form with provided data and submit
        contactPage.fillForm(name, email, subject, message);

        // Assert that the success toast is displayed
        assertUtils.assertElementIsVisible(toast.getToastMessage());

        // Assert that the toast title is "Success"
        assertUtils.assertTextMatches(toast.getToastTitle(), TestData.toastSuccessMessage);
    }
}