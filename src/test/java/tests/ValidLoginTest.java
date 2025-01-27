package tests;

import Helpers.TestValues;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class ValidLoginTest extends BaseTest {

    @Test
    public void TC001LoginValidParams() {

        String email = TestValues.TEST_VALID_EMAIL;
        String password = TestValues.TEST_VALID_PASSWORD;

        try {
            LoginPage loginPage = new LoginPage().logInWithCredentials(email, password);
            Assertions.assertFalse(loginPage.isLoginErrorMessageVisible(), "Error login message is displayed");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
