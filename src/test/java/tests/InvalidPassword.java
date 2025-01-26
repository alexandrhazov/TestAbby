package tests;

import Helpers.TestValues;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class InvalidPassword extends BaseTest {

    @Test
    public void TC003LoginInvalidPassword() {

        String email = TestValues.TEST_VALID_EMAIL;
        String password = TestValues.TEST_INVALID_PASSWORD;

        try {
            LoginPage loginPage = new LoginPage().logInWithCredentials(email, password);
            Assertions.assertTrue(loginPage.isLoginErrorMessageVisible(), "Error message should be visible");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }
}
