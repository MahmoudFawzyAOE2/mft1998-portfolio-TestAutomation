package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.WaitUtils;

public class Toast extends BasePage {
    /*-----------  Constructor  -----------*/
    public Toast(WebDriver driver) {
        super(driver);
    }

    /*-----------  Locators  -----------*/
    By toastMessageLocator = By.id("toast-viewport");
    By toastCloseButtonLocator = By.id("toast-close");
    By toastTitleLocator = By.id("toast-title");
    By toastDescriptionLocator = By.id("toast-description");

    /*-----------  Actions  -----------*/
    public WebElement getToastMessage() {
        return waitUtils.waitForVisibility(toastMessageLocator);
    }
    public WebElement getToastTitle() {
        return waitUtils.waitForVisibility(toastTitleLocator);
    }
    public WebElement getToastDescription() {
        return waitUtils.waitForVisibility(toastDescriptionLocator);
    }
    public void closeToast() {
        waitUtils.waitForVisibility(toastCloseButtonLocator).click();
    }

}
