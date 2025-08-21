package utils;

public class EnvironmentUtils {
        public static boolean isHeadless() {
            return Boolean.parseBoolean(System.getProperty("Headless", "false"));
        }
}