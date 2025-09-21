package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Supplier;

public class WaitUtils {

    private final WebDriverWait wait;

    /*-----------  Constructor  -----------*/
    public WaitUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    /*-----------  Wait Methods  -----------*/
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForURLToBe(String expectedURL) {
        try {
            return wait.until(driver -> driver.getCurrentUrl().equals(expectedURL));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitForUrlContains(String partialUrl) {
        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public void waitForNumberOfElementsToBe(By locator, int expectedCount) {
        wait.until(driver -> driver.findElements(locator).size() == expectedCount);
    }

    public void waitForCount(Supplier<Integer> countSupplier, int expectedCount) {
        wait.until(driver -> countSupplier.get() == expectedCount);
    }

}