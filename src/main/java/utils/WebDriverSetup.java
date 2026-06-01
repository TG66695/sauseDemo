package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetup {

    public static WebDriver setupWebDriver() {
        return new ChromeDriver();
    }
}
