package elements.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.WebDriverUtil;

import java.util.List;

abstract public class BaseField {
    public final By locator;
    public final BaseField parent;

    public BaseField(By locator) {
        this(null, locator);
    }

    public BaseField(BaseField parent, By locator) {
        this.locator = locator;
        this.parent = parent;
    }

    public WebElement getWebElement() {
        return WebDriverUtil.getElement(locator);
    }

    public List<WebElement> getWebElements() {
        return WebDriverUtil.getElements(locator);
    }

    public void setValue(String value) {
        WebElement element = getWebElement();
        element.sendKeys(value);
    }

    public void click() {
        WebDriverUtil.click(getWebElement());
    }

    public String getValue() {
        return WebDriverUtil.getValue(getWebElement());
    }

    public Integer getIntValue() {
        return WebDriverUtil.getIntValue(getWebElement());
    }

    public Boolean isDisplayed() {
        try {
            WebElement element = getWebElement();
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

}
