package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage {

    /*-----------  Constructor  -----------*/

    // Main constructor, public to be accessible from test classes
    // super(driver) will create instances of WaitUtils and ElementActions
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
        elementActions.clickElement(githubButton);
    }
    public void clickLinkedInIcon() {
        WebElement linkedinButton = waitUtils.waitForVisibility(linkedinLocator);
        elementActions.clickElement(linkedinButton);
    }
    public void clickWhatsAppIcon() {
        WebElement whatsappButton = waitUtils.waitForVisibility(whatsappLocator);
        elementActions.clickElement(whatsappButton);
    }
    public void fillForm(String name, String email, String subject, String message) {
        elementActions.enterTextInField(nameFieldLocator, name);
        elementActions.enterTextInField(emailFieldLocator, email);
        elementActions.enterTextInField(subjectFieldLocator, subject);
        elementActions.enterTextInField(messageFieldLocator, message);
        elementActions.clickElement(sendButtonLocator);
    }

}
