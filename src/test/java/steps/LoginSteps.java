package steps;

import constants.PropertyConfigs;
import converter.StringToIntConverter;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.ProductsPage;
import utils.WebDriverUtil;

public class LoginSteps {

    @Step("User opens webpage")
    public void userOpensWebpage() {
        WebDriverUtil.getDriver().navigate().to(PropertyConfigs.APP_URL);
    }

    @Step("User is on login page")
    public void userIsOnLoginPage() {
        Assertions.assertTrue(LoginPage.userField.isDisplayed(), "User field is not displayed");
        Assertions.assertTrue(LoginPage.passwordField.isDisplayed(), "Password field is not displayed");
        Assertions.assertTrue(LoginPage.loginBtn.isDisplayed(), "Login button is not displayed");
    }

    @Step("User puts {row} username from usernames list into username field")
    public void userPutsLogin(String row) {
        Assertions.assertTrue(LoginPage.userField.isDisplayed(), "User field is not displayed");
        int line = StringToIntConverter.getIntFromString(row);
        LoginPage.userField.setValue(LoginPage.detectLogin(line));
    }

    @Step("User puts password {password} into password field")
    public void userPutsPassword(String password) {
        Assertions.assertTrue(LoginPage.passwordField.isDisplayed(), "Password field is not displayed");
        LoginPage.passwordField.setValue(password);
    }

    @Step("User clicks login button")
    public void userClicksLoginButton() {
        Assertions.assertTrue(LoginPage.loginBtn.isDisplayed(), "Login button is not displayed");
        LoginPage.loginBtn.click();
    }

    @Step("User successfully logged in")
    public void userSuccessfullyLoggedIn() {
        Assertions.assertTrue(ProductsPage.productsList.isDisplayed(), "List of products is not displayed");
    }

    @Step("User logged into system as {username} with password {password}")
    public void userLoggedIntoSystem(String username, String password) {
        LoginPage.userLogin(username, password);
    }

    @Step("User gets the message about locked user")
    public void userGetTheMessageAboutLockedUser() {
        String errorMsg = LoginPage.lockedUserMsg.getValue();
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMsg, "Messages are not equal");
    }
}
