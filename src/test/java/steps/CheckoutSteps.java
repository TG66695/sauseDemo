package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutSteps {

    @Step("User clicks on checkout button")
    public void userClicksOnCheckoutBtn() {
        Assertions.assertTrue(CartPage.checkoutBtn.isDisplayed(), "Button is not exists");
        CartPage.checkoutBtn.click();
    }

    @Step("User is on checkout page")
    public void userIsOnCheckoutPage() {
        Assertions.assertTrue(CheckoutPage.pageTitle.isDisplayed(), "Page title is not displayed");
        Assertions.assertTrue(CheckoutPage.firstName.isDisplayed(), "First name field is not displayed");
        Assertions.assertTrue(CheckoutPage.lastName.isDisplayed(), "Last name field is not displayed");
        Assertions.assertTrue(CheckoutPage.zipPostal.isDisplayed(), "Zip/Postal field is not displayed");
        Assertions.assertTrue(CheckoutPage.continueBtn.isDisplayed(), "Continue button is not displayed");
        Assertions.assertTrue(CheckoutPage.cancelBtn.isDisplayed(), "Cancel button is not displayed");
        String title = CheckoutPage.pageTitle.getValue();
        Assertions.assertEquals("Checkout: Your Information", title, "Values are not equal");
    }

    @Step("User puts first name {fName} into first name field")
    public void userPutsFirstNameJohnIntoFirstNameField(String fName) {
        CheckoutPage.firstName.setValue(fName);
    }

    @Step("User puts last name {lName} into last name field")
    public void userPutsLastNameSmithIntoLastNameField(String lName) {
        CheckoutPage.lastName.setValue(lName);
    }

    @Step("User puts postal code {number} into postal code field")
    public void userPutsPostalCodeIntoPostalCodeField(int number) {
        CheckoutPage.zipPostal.setValue(String.valueOf(number));
    }

    @Step("User clicks continue button")
    public void userClicksContinueButton() {
        CheckoutPage.continueBtn.click();
    }

    @Step("User is in checkout overview page")
    public void userIsInCheckoutOverviewPage() {
        Assertions.assertTrue(CartPage.cartItem.isDisplayed(), "No item in the cart");
        Assertions.assertTrue(CheckoutPage.paymentInfoValue.isDisplayed(), "Payment info value is not displayed");
        Assertions.assertTrue(CheckoutPage.shippingInfoTxt.isDisplayed(), "Shipping info label is not displayed");
        Assertions.assertTrue(CheckoutPage.shippingInfoValue.isDisplayed(), "Shipping info value is not displayed");
        Assertions.assertTrue(CheckoutPage.priceTotalTxt.isDisplayed(), "Price label is not displayed");
        Assertions.assertTrue(CheckoutPage.subtotalValue.isDisplayed(), "Sub-total info is not displayed");
        Assertions.assertTrue(CheckoutPage.taxValue.isDisplayed(), "Tax info is not displayed");
        Assertions.assertTrue(CheckoutPage.cancelBtn.isDisplayed(), "Cancel button is not displayed");
        Assertions.assertTrue(CheckoutPage.finishBtn.isDisplayed(), "Finish button is not displayed");
    }

    @Step("User verifies payment information")
    public void userVerifiesPaymentInformation() {
        String paymentInfo = CheckoutPage.paymentInfoValue.getValue();
        Assertions.assertEquals("SauceCard #31337", paymentInfo, "Values are not equal");
    }

    @Step("User verifies shipping information")
    public void userVerifiesShippingInformation() {
        String shipInfo = CheckoutPage.shippingInfoValue.getValue();
        Assertions.assertEquals("Free Pony Express Delivery!", shipInfo, "Values are not equal");
    }

    @Step("User verifies price information")
    public void userVerifiesPriceInformation() {
        double totalPriceOfItems = CheckoutPage.calculatePricePlusTax();
        double totalPriceOnThePage = CheckoutPage.cutTheTotalPrice();
        double delta = 0.001;
        Assertions.assertEquals(totalPriceOfItems, totalPriceOnThePage, delta, "Values are not equal");
    }

    @Step("User clicks on finish button")
    public void userClicksOnFinishButton() {
        CheckoutPage.finishBtn.click();
    }

    @Step("User is on complete page")
    public void userIsOnCompletePage() {
        Assertions.assertTrue(CheckoutPage.checkoutCompleteContainer.isDisplayed(), "Completion container is not exists");
        Assertions.assertTrue(CheckoutPage.backHomeBtn.isDisplayed(), "Button is not displayed");
    }
}
