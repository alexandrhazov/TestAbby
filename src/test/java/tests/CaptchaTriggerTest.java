package tests;

import Helpers.TestValues;
import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class CaptchaTriggerTest extends BaseTest {

    @Test
    public void TC004VerifyCaptchaTriggered() {

        String email = TestValues.TEST_INVALID_EMAIL;
        String password = TestValues.TEST_INVALID_PASSWORD;

        try {
            LoginPage loginPage = new LoginPage();
            for (int i = 0; i < 3; i++) {
                loginPage.logInWithCredentials(email, password);
                loginPage.clearLoginField();
                loginPage.clearPasswordField();
            }
            Assertions.assertTrue(loginPage.isCaptchaVisible(), "Captcha should be visible after 3 failed login attempts.");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
