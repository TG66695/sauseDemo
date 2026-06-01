package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.CartSteps;
import steps.CheckoutSteps;
import steps.LoginSteps;
import steps.ProductPageSteps;

@Feature("Checkout process")
@Tag("testSuite")
public class CheckoutTest extends BaseTest {
    private final LoginSteps loginSteps = new LoginSteps();
    private final ProductPageSteps productPageSteps = new ProductPageSteps();
    private final CartSteps cartSteps = new CartSteps();
    private final CheckoutSteps checkoutSteps = new CheckoutSteps();

    @Test
    @Story("Add product to the cart and proceed with checkout process")
    @Tag("Checkout")
    public void addProductToCartAndProceedWithCheckout() {
        loginSteps.userOpensWebpage();
        loginSteps.userLoggedIntoSystem("standard_user", "secret_sauce");
        productPageSteps.userClicksAddButton("second");
        productPageSteps.userSavesTheTitle("second");
        productPageSteps.productIsInTheCart(1);
        cartSteps.userClicksOnCartButton();
        cartSteps.userIsInTheCart();
        cartSteps.userValidatesAddedItemDescription("first");
        productPageSteps.userClearsControlTitle();
        checkoutSteps.userClicksOnCheckoutBtn();
        checkoutSteps.userIsOnCheckoutPage();
        checkoutSteps.userPutsFirstNameJohnIntoFirstNameField("John");
        checkoutSteps.userPutsLastNameSmithIntoLastNameField("Smith");
        checkoutSteps.userPutsPostalCodeIntoPostalCodeField(888);
        checkoutSteps.userClicksContinueButton();
        checkoutSteps.userIsInCheckoutOverviewPage();
        checkoutSteps.userVerifiesPaymentInformation();
        checkoutSteps.userVerifiesShippingInformation();
        checkoutSteps.userVerifiesPriceInformation();
        checkoutSteps.userClicksOnFinishButton();
        checkoutSteps.userIsOnCompletePage();
    }
}
