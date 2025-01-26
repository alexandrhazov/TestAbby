package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import pages.LoginPage;

public class DesignResponsiveness extends BaseTest {

    @Test
    public void TC008TestDesignResponsiveness1023x778() {

        try {
            LoginPage loginPage = new LoginPage();
            driver.manage().window().setSize(new Dimension(1023, 778));
            Assertions.assertTrue(loginPage.isLoginFormFullscreen(), "Login form should display full screen at width 1023");

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void TC010DesignResponsiveness1025x778() {

        try {
            LoginPage loginPage = new LoginPage();
            driver.manage().window().setSize(new Dimension(1025, 778));
            Assertions.assertTrue(loginPage.isRightMenuVisible(), "Login form should not display full screen at width 1025 according to requirements (below 1024x");

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void TC009DesignResponsiveness1024x778() {

        try {
            LoginPage loginPage = new LoginPage();
            driver.manage().window().setSize(new Dimension(1024, 778));
            System.out.println("Right Menu Visibility: " + loginPage.isRightMenuVisible());
            Assertions.assertTrue(loginPage.isRightMenuVisible(), "Login form should not display full screen at width 1024 according to requirements (below 1024x");
        }  catch (TimeoutException e) {
                Assertions.fail("Timeout while waiting: " + e.getMessage());
        }
           catch (Exception d) {
                Assertions.fail(d.getMessage());
        }
    }
}
