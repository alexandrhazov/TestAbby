package pages;

import Helpers.ConfigProvider;
import Helpers.DefaultConfigProvider;
import Helpers.TestValues;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private ConfigProvider configProvider;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "signInButton")
    private WebElement signInField;

    @FindBy(xpath = "//a[@href='reset-password']")
    private WebElement forgotPasswordField;

    @FindBy(css = "[data-testid='ssoLoginButton']")
    private WebElement loginWithSSOField;

    @FindBy(css = "[data-testid='visibilityShowIconV2']")
    private WebElement togglePasswordVisibility;

    @FindBy(css = "[data-testid='visibilityHideIconV2']")
    private WebElement togglePasswordInvisibility;

    @FindBy(id = "loginErrorMessage")
    private WebElement loginErrorMessage;

    @FindBy(css = "[data-testid='emailErrorMessage']")
    private WebElement loginSSOErrorMessage;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement signInSSOField;

    //Mock css for Captcha as there is no currently implemented in testing URL
    @FindBy(css = "iframe[src*='captcha']")
    private WebElement captchaField;

    @FindBy(id = "layout-right-column-body")
    private WebElement rightColumnBody;


    public LoginPage() {
        this.configProvider = new DefaultConfigProvider();
        driver.get(configProvider.getBaseUrl());
        PageFactory.initElements(driver, this);
    }

    public LoginPage logInWithCredentials(String email, String password) {
        emailField.click();
        emailField.sendKeys(email);
        passwordField.click();
        passwordField.sendKeys(password);
        signInField.click();
        return this;
    }

    public LoginPage logInWithSSO(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginWithSSOField.click();
        wait.until(ExpectedConditions.elementToBeClickable(signInSSOField));
        emailField.click();
        emailField.sendKeys(email);
        signInSSOField.click();
        return this;
    }

    public LoginPage ForgotPassword(String email) {
        forgotPasswordField.click();
        emailField.click();
        emailField.sendKeys();
        return this;
    }

    public LoginPage TogglePasswordVisibility(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
        togglePasswordVisibility.click();
        return this;
    }

    public LoginPage TogglePasswordInvisibility() {
        togglePasswordInvisibility.click();
        return this;
    }

    public LoginPage clearLoginField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.click();
        emailField.clear();
        return this;
    }

    public LoginPage clearPasswordField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.click();
        passwordField.clear();
        return this;
    }

    public boolean isPasswordVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(passwordField, "type", "text"));
        return "text".equals(passwordField.getAttribute("type"));
    }

    public boolean isPasswordInvisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(passwordField, "type", "password"));
        return "password".equals(passwordField.getAttribute("type"));
    }

    public boolean isLoginErrorMessageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        return loginErrorMessage.isDisplayed();
    }

    public boolean isLoginSSOErrorMessageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginSSOErrorMessage));
        return loginSSOErrorMessage.isDisplayed();
    }

    public boolean isCaptchaVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(captchaField));
        return captchaField.isDisplayed();
    }

    public boolean isLoginFormFullscreen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(rightColumnBody));
        return !rightColumnBody.isDisplayed();
    }

    public boolean isRightMenuVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(rightColumnBody));
        return rightColumnBody.isDisplayed();
    }








}
