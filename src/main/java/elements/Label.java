package elements;

import elements.base.BaseField;
import org.openqa.selenium.By;

public class Label extends BaseField {
    public Label(BaseField parent, By locator) {
        super(parent, locator);
    }

    public Label(By locator) {
        super(locator);
    }

}
