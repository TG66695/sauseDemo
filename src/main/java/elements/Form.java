package elements;

import elements.base.BaseField;
import org.openqa.selenium.By;

public class Form extends BaseField {
    public Form(BaseField parent, By locator) {
        super(parent, locator);
    }

    public Form(By locator) {
        super(locator);
    }

}
