package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactPage extends BasePage {

    /*-----------  Constructor  -----------*/
    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /*-----------  Locators  -----------*/
    By githubLocator = By.id("btn-github");
    By linkedinLocator = By.id("btn-linkedin");
    By emailLocator = By.id("btn-email");
    By whatsappLocator = By.id("btn-whatsapp");

    /*-----------  Actions  -----------*/
    public void clickGithubIcon() {
        WebElement githubButton = driver.findElement(githubLocator);
        githubButton.click();
    }
    public void clickLinkedInIcon() {
        WebElement linkedinButton = driver.findElement(linkedinLocator);
        linkedinButton.click();
    }
    public void clickEmailIcon() {
        WebElement emailButton = driver.findElement(emailLocator);
        emailButton.click();
    }
    public void clickWhatsAppIcon() {
        WebElement whatsappButton = driver.findElement(whatsappLocator);
        whatsappButton.click();
    }
}
