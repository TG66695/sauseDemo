package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.CartSteps;
import steps.LoginSteps;
import steps.ProductPageSteps;

@Feature("Cart validation")
@Tag("testSuite")
public class CartValidationTest extends BaseTest {
    private final LoginSteps loginSteps = new LoginSteps();
    private final ProductPageSteps productPageSteps = new ProductPageSteps();
    private final CartSteps cartSteps = new CartSteps();

    @Test
    @Story("One item addition into cart validation")
    @Tag("CartValidation")
    public void oneItemAdditionIntoCartValidation() {
        loginSteps.userOpensWebpage();
        loginSteps.userLoggedIntoSystem("standard_user", "secret_sauce");
        productPageSteps.userClicksAddButton("first");
        productPageSteps.userSavesTheTitle("first");
        productPageSteps.productIsInTheCart(1);
        cartSteps.userClicksOnCartButton();
        cartSteps.userIsInTheCart();
        cartSteps.userValidatesAddedItemDescription("first");
        productPageSteps.userClearsControlTitle();
    }

    @Test
    @Story("Few items addition into cart validation")
    @Tag("CartValidation")
    public void fewItemsAdditionIntoCartValidation() {
        loginSteps.userOpensWebpage();
        loginSteps.userLoggedIntoSystem("standard_user", "secret_sauce");
        productPageSteps.userClicksAddButton("first");
        productPageSteps.userSavesTheTitle("first");
        productPageSteps.userClicksAddButton("third");
        productPageSteps.userSavesTheTitle("third");
        productPageSteps.userClicksAddButton("fourth");
        productPageSteps.userSavesTheTitle("fourth");
        productPageSteps.productIsInTheCart(3);
        cartSteps.userClicksOnCartButton();
        cartSteps.userIsInTheCart();
        cartSteps.userValidatesAddedItemDescription("first");
        cartSteps.userValidatesAddedItemDescription("second");
        cartSteps.userValidatesAddedItemDescription("third");
        productPageSteps.userClearsControlTitle();
    }
}
