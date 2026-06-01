package elements;

import elements.base.BaseField;
import org.openqa.selenium.By;

public class TextBox extends BaseField {
    public TextBox(BaseField parent, By locator) {
        super(parent, locator);
    }

    public TextBox(By locator) {
        super(locator);
    }
}
