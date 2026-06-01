package elements;

import elements.base.BaseField;
import org.openqa.selenium.By;

public class SideMenu extends BaseField {
    public SideMenu(By locator) {
        super(locator);
    }

    public final Link allItems = new Link(this, By.id("inventory_sidebar_link"));
    public final Link about = new Link(this, By.id("about_sidebar_link"));
    public final Link logout = new Link(this, By.id("logout_sidebar_link"));
    public final Link resetAppState = new Link(this, By.id("reset_sidebar_link"));
    public final Button crossBtn = new Button(this, By.id("react-burger-cross-btn"));
}
