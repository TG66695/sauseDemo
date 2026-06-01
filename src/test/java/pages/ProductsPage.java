package pages;

import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    public static String addToCartBtn = "//div[@class = 'inventory_item'][%s]//button";
    public static final Form productsList = new Form(By.xpath("//div[@class = 'inventory_list']"));
    public static final Button cartBtn = new Button(By.xpath("//a[@class = 'shopping_cart_link']"));
    public static final Label cartBadge = new Label(By.xpath("//span[@class = 'shopping_cart_badge']"));
    public static final Button removeBtn = new Button(By.xpath("//button[contains(text(), 'Remove')]"));
    public static String ProductTitle = "//div[@class ='inventory_item'][%s]//div[@class ='inventory_item_name ']";
    public static final SideMenu burgerMenuBtn = new SideMenu(By.xpath("//button[@id = 'react-burger-menu-btn']"));
    public static final Form sortMenu = new Form(By.xpath("//select[@class = 'product_sort_container']"));


    public static void clickAddToCartButton(Integer num) {
        Button addBtn = new Button(By.xpath(String.format(addToCartBtn, num)));
        addBtn.click();
    }

    public static String getItemTitleOnProductPage(Integer number) {
        TextBox text = new TextBox(By.xpath(String.format(ProductTitle, number)));
        return text.getValue();
    }

    public static Integer findAmountOfRemoveButtons() {
        List<WebElement> elemsList = removeBtn.getWebElements();
        return elemsList.size();
    }
}
