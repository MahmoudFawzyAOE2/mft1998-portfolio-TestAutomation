package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testData.TestData;

public class ContactPage extends BasePage {

    /*-----------  Constructor  -----------*/
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    /*-----------  Locators  -----------*/
    By githubLocator = By.id("btn-github");
    By linkedinLocator = By.id("btn-linkedin");
    By whatsappLocator = By.id("btn-whatsapp");

    By nameFieldLocator = By.id("name");
    By emailFieldLocator = By.id("email");
    By messageFieldLocator = By.id("message");
    By subjectFieldLocator = By.id("subject");

    By sendButtonLocator = By.cssSelector("button[type='submit']");

    /*-----------  Actions  -----------*/
    public void clickGithubIcon() {
        WebElement githubButton = waitUtils.waitForVisibility(githubLocator);
        githubButton.click();
    }
    public void clickLinkedInIcon() {
        WebElement linkedinButton = waitUtils.waitForVisibility(linkedinLocator);
        linkedinButton.click();
    }
    public void clickWhatsAppIcon() {
        WebElement whatsappButton = waitUtils.waitForVisibility(whatsappLocator);
        whatsappButton.click();
    }
    public void fillForm(String name, String email, String subject, String message) {
        waitUtils.waitForVisibility(nameFieldLocator).sendKeys(name);
        waitUtils.waitForVisibility(emailFieldLocator).sendKeys(email);
        waitUtils.waitForVisibility(subjectFieldLocator).sendKeys(subject);
        waitUtils.waitForVisibility(messageFieldLocator).sendKeys(message);
        waitUtils.waitForVisibility(sendButtonLocator).click();
    }

}
