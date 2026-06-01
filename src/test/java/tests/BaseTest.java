package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.TestResultExtension;
import utils.WebDriverUtil;

@ExtendWith(TestResultExtension.class)
public class BaseTest {

    @BeforeEach
    public void setUp() {
        WebDriverUtil.getDriver();
    }

    @AfterEach
    public void tearDown() {
        try {
            if (WebDriverUtil.getDriver() != null) {
                WebDriverUtil.getDriver().quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            WebDriverUtil.setDriver(null);
        }
    }
}
