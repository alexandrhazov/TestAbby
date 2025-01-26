package tests;

import Helpers.TestValues;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class PasswordToggleTest extends BaseTest {

    @Test
    public void TC007PasswordToggleOnAndOff() {

        String password = TestValues.TEST_VALID_PASSWORD;

        try {
            LoginPage loginPage = new LoginPage().TogglePasswordVisibility(password);
            Assertions.assertTrue(loginPage.isPasswordVisible(), "Password should be visible");

            loginPage.TogglePasswordInvisibility();
            Assertions.assertTrue(loginPage.isPasswordInvisible(), "Password should be invisible");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }
}
