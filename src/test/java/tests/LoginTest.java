package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.LoginSteps;

@Feature("Login")
@Tag("testSuite")
public class LoginTest extends BaseTest {
    private final LoginSteps loginSteps = new LoginSteps();

    @Test
    @Story("Login into application")
    @Tag("login")
    public void loginIntoApplication() {
        loginSteps.userOpensWebpage();
        loginSteps.userIsOnLoginPage();
        loginSteps.userPutsLogin("first");
        loginSteps.userPutsPassword("secret_sauce");
        loginSteps.userClicksLoginButton();
        loginSteps.userSuccessfullyLoggedIn();
    }

    @Test
    @Story("Try login into application as locked user")
    @Tag("login")
    public void tryLoginIntoApplicationAsLockedUser() {
        loginSteps.userOpensWebpage();
        loginSteps.userIsOnLoginPage();
        loginSteps.userPutsLogin("second");
        loginSteps.userPutsPassword("secret_sauce");
        loginSteps.userClicksLoginButton();
        loginSteps.userGetTheMessageAboutLockedUser();
    }
}
