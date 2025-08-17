package utils;

import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotUtils {

    private final WebDriver driver;

    public RobotUtils(WebDriver driver) {
        this.driver = driver;
    }

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
