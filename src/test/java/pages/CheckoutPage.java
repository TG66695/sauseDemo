package pages;

import elements.Button;
import elements.Label;
import elements.TextBox;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckoutPage {

    public static final Label pageTitle = new Label(By.xpath("//span[@class = 'title']"));
    public static final TextBox firstName = new TextBox(By.id("first-name"));
    public static final TextBox lastName = new TextBox(By.id("last-name"));
    public static final TextBox zipPostal = new TextBox(By.id("postal-code"));
    public static final Button cancelBtn = new Button(By.id("cancel"));
    public static final Button continueBtn = new Button(By.id("continue"));

    public static final Label paymentInfoTxt = new Label(By.xpath("//div[@class = 'summary_info_label' and text()= 'Payment Information']"));
    public static final Label paymentInfoValue = new Label(By.xpath("//div[@class = 'summary_info']/div[@class = 'summary_value_label'][1]"));
    public static final Label shippingInfoTxt = new Label(By.xpath("//div[@class = 'summary_info_label' and text()= 'Shipping Information']"));
    public static final Label shippingInfoValue = new Label(By.xpath("//div[@class = 'summary_info']/div[@class = 'summary_value_label'][2]"));
    public static final Label priceTotalTxt = new Label(By.xpath("//div[@class = 'summary_info_label' and text()= 'Price Total']"));
    public static final Label subtotalValue = new Label(By.xpath("//div[@class = 'summary_subtotal_label']"));
    public static final Label taxValue = new Label(By.xpath("//div[@class = 'summary_tax_label']"));
    public static final Label totalValue = new Label(By.xpath("//div[contains(@class, 'summary_total_label')]"));
    public static final Button finishBtn = new Button(By.id("finish"));
    public static final Button backHomeBtn = new Button(By.id("back-to-products"));
    public static final Label checkoutCompleteContainer = new Label(By.id("checkout_complete_container"));

    public static double cutTheTotalPrice() {
        String priceText = totalValue.getWebElement().getText();
        String clearedString = priceText.replaceAll("[^\\d.]+", "");
        return Double.parseDouble(clearedString);
    }

    public static double calculatePricePlusTax() {
        double total = CartPage.getItemsPriceTotal() + ((8 * CartPage.getItemsPriceTotal()) / 100);
        int scale = 2;
        return BigDecimal.valueOf(total).setScale(scale, RoundingMode.CEILING).doubleValue();
    }

}



