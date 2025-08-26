package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testData.TestData;

public class ContactPage extends BasePage {

    /*-----------  Constructor  -----------*/
    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
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
        WebElement githubButton = driver.findElement(githubLocator);
        githubButton.click();
    }
    public void clickLinkedInIcon() {
        WebElement linkedinButton = driver.findElement(linkedinLocator);
        linkedinButton.click();
    }
    public void clickWhatsAppIcon() {
        WebElement whatsappButton = driver.findElement(whatsappLocator);
        whatsappButton.click();
    }
    public void fillForm(String name, String email, String subject, String message) {
        driver.findElement(nameFieldLocator).sendKeys(name);
        driver.findElement(emailFieldLocator).sendKeys(email);
        driver.findElement(subjectFieldLocator).sendKeys(subject);
        driver.findElement(messageFieldLocator).sendKeys(message);
        driver.findElement(sendButtonLocator).click();
    }

}
