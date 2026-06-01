package elements;

import elements.base.BaseField;
import org.openqa.selenium.By;

public class Link extends BaseField {
    public Link(By locator) {
        super(locator);
    }

    public Link(BaseField parent, By locator) {
        super(parent, locator);
    }
}
