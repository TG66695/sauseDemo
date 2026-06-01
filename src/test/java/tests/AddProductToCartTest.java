package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.LoginSteps;
import steps.ProductPageSteps;

@Feature("Add product into cart")
@Tag("testSuite")
public class AddProductToCartTest extends BaseTest {
    private final LoginSteps loginSteps = new LoginSteps();
    private final ProductPageSteps productPageSteps = new ProductPageSteps();

    @Test
    @Story("User adds product to cart")
    @Tag("AddToCart")
    public void userAddsProductToCart() {
        loginSteps.userOpensWebpage();
        loginSteps.userLoggedIntoSystem("standard_user", "secret_sauce");
        productPageSteps.userClicksAddButton("third");
        productPageSteps.productIsInTheCart(1);
        productPageSteps.removeButtonAppears(1);
    }

    @Test
    @Story("User adds two products into cart")
    @Tag("AddToCart")
    public void userAddsTwoProductsIntoCart() {
        loginSteps.userOpensWebpage();
        loginSteps.userLoggedIntoSystem("standard_user", "secret_sauce");
        productPageSteps.userClicksAddButton("third");
        productPageSteps.userClicksAddButton("first");
        productPageSteps.productIsInTheCart(2);
        productPageSteps.removeButtonAppears(2);
    }
}
