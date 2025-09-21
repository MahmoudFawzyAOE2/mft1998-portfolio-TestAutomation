package utils;

import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotUtils {
    /* Useful for handling OS-level popups like file upload dialogs */

    private final WebDriver driver;

    /*-----------  Constructor  -----------*/
    public RobotUtils(WebDriver driver) {
        this.driver = driver;
    }

    /*-----------  Actions  -----------*/
    // Method to simulate pressing the Enter key
    // Static method to allow calling without instantiating the class
    public static void pressEnter() {
        try {
            Robot robot = new Robot();
            robot.delay(1000); // wait 1 sec to ensure popup is visible
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
