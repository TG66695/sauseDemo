package pages;

import elements.Button;
import elements.Label;
import elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    public static final Label yourCartLabel = new Label(By.xpath("//span[text() = 'Your Cart']"));
    public static final Label cartItem = new Label(By.xpath("//div[@class ='cart_item']"));
    public static String cartItemTitle = "//div[@class ='cart_item'][%s]//div[@class = 'inventory_item_name']";
    public static Label cartItemPrice = new Label(By.xpath("//div[@class ='cart_item']//div[@class = 'inventory_item_price']"));
    public static Button checkoutBtn = new Button(By.id("checkout"));
    public static Button continueShoppingBtn = new Button(By.id("continue-shopping"));

    public static String getCartItemTitle(Integer number) {
        TextBox itemTitle = new TextBox(By.xpath(String.format(cartItemTitle, number)));
        return itemTitle.getValue();
    }

    public static double getItemsPriceTotal() {
        List<WebElement> priceList = cartItemPrice.getWebElements();
        double total = 0;
        for (WebElement element : priceList) {
            String priceText = element.getText();
            String clearedString = priceText.replaceAll("[^\\d.]+", "");
            double priceValue = Double.parseDouble(clearedString);
            total += priceValue;
        }
        return total;

    }
}