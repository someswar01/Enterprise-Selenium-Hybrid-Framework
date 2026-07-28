package pages;

import org.openqa.selenium.By;

import base.BasePage;
import logger.FrameworkLogger;

import static actions.ElementActions.type;
import static utilities.DropdownUtils.selectByVisibleText;

public class LoginPage extends BasePage {

    // ===========================
    // Locators
    // ===========================

    private final By usernameTextBox = By.id("username");
    private final By passwordTextBox = By.id("password");
    private final By userRadioButton = By.cssSelector("input[value='user']+span");
    private final By adminRadioButton = By.cssSelector("input[value='admin']+span");
    private final By okayButton = By.id("okayBtn");
    private final By roleDropdown = By.cssSelector("select.form-control");
    private final By termsCheckbox = By.cssSelector("input[name='terms']");
    private final By signInButton = By.id("signInBtn");
    private final By errorMessage = By.cssSelector(".alert-danger");

    // ===========================
    // Business Methods
    // ===========================

    /**
     * Valid Login
     */
    public HomePage login(String username, String password) {

        FrameworkLogger.info("Login starts");

        enterUsername(username);

        enterPassword(password);

        selectUserRole();

        acceptTerms();

        clickSignIn();

        return new HomePage();
    }

    /**
     * Invalid Login
     */
    public LoginPage loginExpectingFailure(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickSignIn();

        return this;
    }

    // ===========================
    // Individual Actions
    // ===========================

    private void enterUsername(String username) {

        FrameworkLogger.info("Entering username");

        type(usernameTextBox, username);
    }

    private void enterPassword(String password) {

        FrameworkLogger.info("Entering password");

        type(passwordTextBox, password);
    }

    private void selectUserRole() {

        FrameworkLogger.info("Selecting User radio button");

        click(userRadioButton);

        FrameworkLogger.info("Accepting browser alert");

        click(okayButton);

        FrameworkLogger.info("Selecting User role");

        selectByVisibleText(roleDropdown, "Teacher");
    }

    private void acceptTerms() {

        FrameworkLogger.info("Accepting Terms & Conditions");

        click(termsCheckbox);
    }

    private void clickSignIn() {

        FrameworkLogger.info("Clicking Sign In button");

        click(signInButton);
    }

    // ===========================
    // Getters
    // ===========================

    public String getLoginErrorMessage() {

        FrameworkLogger.info("Getting login error message");

        return getText(errorMessage);
    }
}