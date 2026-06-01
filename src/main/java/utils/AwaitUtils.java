package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.Callable;

public class AwaitUtils {

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean waitForConditionWithFluentWait(String message, Callable<Boolean> condition, int timeout) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(WebDriverUtil.getDriver())
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            wait.until(driver -> {
                try {
                    return condition.call();
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            });
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}

