package tests;

import Helpers.TestValues;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginWithInvalidSSO extends BaseTest {

    @Test
    public void TC016InvalidLoginWithSSO() {
            String email = TestValues.TEST_INVALID_EMAIL;

            try {
                LoginPage loginPage = new LoginPage().logInWithSSO(email);
                Assertions.assertTrue(loginPage.isLoginSSOErrorMessageVisible(), "Error login message is displayed");
            } catch (Exception e) {
                Assertions.fail(e.getMessage());
            }
    }
}
