package utils;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class DriverUtils {

    private final WebDriver driver ;
    private WaitUtils waitUtils;

    public DriverUtils(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void viewAllTabs(){
        List<String> tabs = driver.getWindowHandles().stream().toList();
        System.out.println("Number of open tabs: " + tabs.size());
        System.out.println(tabs);
    }
    public void viewCurrentTab() {
        String currentTab = driver.getWindowHandle();
        System.out.println("Current Tab: " + currentTab);
        System.out.println("Current Tab Title: " + driver.getTitle());
    }
    public void switchToTab(int index) {
        List<String> tabs = driver.getWindowHandles().stream().toList();
        if (index >= 0 && index < tabs.size()) {
            driver.switchTo().window(tabs.get(index));
        } else {
            throw new IndexOutOfBoundsException("Tab index out of range: " + index);
        }
    }
    public void switchToLastTab() {
        List<String> tabs = driver.getWindowHandles().stream().toList();
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
