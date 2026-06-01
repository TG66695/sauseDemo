package steps;

import converter.StringToIntConverter;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.ProductsPage;

import java.util.ArrayList;
import java.util.List;

public class ProductPageSteps {
    public static List<String> controlTitle = new ArrayList<>();

    @Step("User clicks 'Add to cart' button for {number} product")
    public void userClicksAddButton(String number) {
        int line = StringToIntConverter.getIntFromString(number);
        ProductsPage.clickAddToCartButton(line);
    }

    @Step("User saves title for {number} product")
    public void userSavesTheTitle(String number) {
        int line = StringToIntConverter.getIntFromString(number);
        controlTitle.add(ProductsPage.getItemTitleOnProductPage(line));
    }

    @Step("{amount} product added to the cart")
    public void productIsInTheCart(int amount) {
        int badgeValue = ProductsPage.cartBadge.getIntValue();
        Assertions.assertEquals(amount, badgeValue, "Card badge doesn't have expected value");
    }

    @Step("{amount} Remove button appears")
    public void removeButtonAppears(int amount) {
        Assertions.assertTrue(ProductsPage.removeBtn.isDisplayed(), "Remove button is not displayed");
        int amountOfRemoveButtons = ProductsPage.findAmountOfRemoveButtons();
        Assertions.assertEquals(amount, amountOfRemoveButtons, "Amount is different");
    }

    @Step("User clears controlTitle")
    public void userClearsControlTitle() {
        controlTitle.clear();
    }
}
