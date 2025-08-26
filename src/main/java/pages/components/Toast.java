package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class Toast extends BasePage {
    /*-----------  Constructor  -----------*/
    public Toast(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /*-----------  Locators  -----------*/
    By toastMessageLocator = By.className("toast-viewport");
    By toastCloseButtonLocator = By.className("toast-close");
    By toastTitleLocator = By.className("toast-title");
    By toastDescriptionLocator = By.className("toast-description");

    /*-----------  Actions  -----------*/
    public WebElement getToastMessage() {
        return driver.findElement(toastMessageLocator);
    }
    public WebElement getToastTitle() {
        return driver.findElement(toastTitleLocator);
    }
    public WebElement getToastDescription() {
        return driver.findElement(toastDescriptionLocator);
    }
    public void closeToast() {
        driver.findElement(toastCloseButtonLocator).click();
    }

}
