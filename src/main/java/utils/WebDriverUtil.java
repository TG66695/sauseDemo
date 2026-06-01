package utils;

import constants.PropertyConfigs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebDriverUtil {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public static void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }

    private static void initializeDriver() {
        driver = WebDriverSetup.setupWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertyConfigs.SELENIUM_IMPLICIT_WAIT));
        driver.manage().deleteAllCookies();
    }

    public static WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(PropertyConfigs.SELENIUM_IMPLICIT_WAIT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return getDriver().findElement(locator);
    }

    public static List<WebElement> getElements(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(PropertyConfigs.SELENIUM_IMPLICIT_WAIT));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return getDriver().findElements(locator);
    }

    public static String getValue(WebElement element) {
        return element.getText().trim();
    }

    public static Integer getIntValue(WebElement element) {
        try {
            return Integer.parseInt(element.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void click(WebElement element) {
        element.click();
    }

}
