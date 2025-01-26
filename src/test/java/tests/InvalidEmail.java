package tests;

import Helpers.TestValues;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class InvalidEmail extends BaseTest {

    @Test
    public void TC002TestLoginInvalidEmail() {

        String email = TestValues.TEST_INVALID_EMAIL;
        String password = TestValues.TEST_VALID_PASSWORD;

        try {
            LoginPage loginPage = new LoginPage().logInWithCredentials(email, password);
            Assertions.assertTrue(loginPage.isLoginErrorMessageVisible(), "Error message should be visible");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }

    }
}
