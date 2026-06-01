package utils;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestResultExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            saveScreenshot(context.getDisplayName());
        }
    }

    @Attachment(value = "{screenshotName}", type = "image/png")
    public byte[] saveScreenshot(String screenshotName) {
        try {
            return ((TakesScreenshot) WebDriverUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
