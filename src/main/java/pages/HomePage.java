package pages;

import java.util.List;

import constants.FrameworkConstants;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BasePage;
import logger.FrameworkLogger;
import utilities.WaitUtils;

import static actions.ElementActions.getElements;
import static utilities.DropdownUtils.getTexts;

public class HomePage extends BasePage {

    // ==========================================
    // Locators
    // ==========================================

    private final By productCards = By.cssSelector(".card");

    private final By productTitles =
            By.cssSelector(".card-title");

    private final By checkoutButton =
            By.cssSelector("a.nav-link.btn.btn-primary");

    // ==========================================
    // Verification Methods
    // ==========================================

    public boolean isHomePageDisplayed() {

        return isDisplayed(checkoutButton);
    }

    public boolean isCheckoutButtonDisplayed() {

        FrameworkLogger.info("Verifying Checkout Button");

        return isDisplayed(checkoutButton);
    }

    public int getProductCount() {

        FrameworkLogger.info("Getting Product Count");

        return getElements(productCards).size();
    }

    // ==========================================
    // Business Methods
    // ==========================================

    public List<WebElement> getAllProducts() {

        FrameworkLogger.info("Getting All Products");

        return getElements(productCards);
    }

    public List<String> getProductNames() {

        FrameworkLogger.info("Getting Product Names");

        return getTexts(productTitles);
    }

    public boolean isProductDisplayed(String productName) {

        FrameworkLogger.info("Searching Product : " + productName);

        return getProductNames()
                .stream()
                .anyMatch(product ->
                        product.equalsIgnoreCase(productName));
    }

    public void clickCheckout() {

        FrameworkLogger.info("Clicking Checkout Button");

        click(checkoutButton);
    }


    /**
     * Returns current page URL.
     */
    public String getCurrentUrl() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    /**
     * Returns current page title.
     */
    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    /**
     * Validates whether user is on Home page.
     */
    public boolean isHomePageLoaded() {

        try {

            WaitUtils.waitForUrlContains("/angularpractice/shop");

            return getCurrentUrl().equals(FrameworkConstants.HOME_PAGE_URL)
                    && getPageTitle().equals(FrameworkConstants.HOME_PAGE_TITLE);

        } catch (Exception e) {
            return false;
        }
    }


}