package steps;

import converter.StringToIntConverter;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.CartPage;
import pages.ProductsPage;
import utils.AwaitUtils;

public class CartSteps {

    @Step("User clicks on cart button")
    public void userClicksOnCartButton() {
        AwaitUtils.waitForConditionWithFluentWait("Cart button is not displayed", ProductsPage.cartBtn::isDisplayed, 2);
        ProductsPage.cartBtn.click();
    }

    @Step("User is in the cart")
    public void userIsInTheCart() {
        Assertions.assertTrue(CartPage.yourCartLabel.isDisplayed(), "Cart label is not displayed");
    }

    @Step("User validates added item {number} in the list description")
    public void userValidatesAddedItemDescription(String number) {
        Assertions.assertTrue(CartPage.cartItem.isDisplayed(), "Cart item is not displayed");
        int line = StringToIntConverter.getIntFromString(number);
        String productTitle = ProductPageSteps.controlTitle.get(line - 1);
        String cartElemTitle = CartPage.getCartItemTitle(line);
        Assertions.assertEquals(productTitle, cartElemTitle, "Values are not equal");
    }
}
