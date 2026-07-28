package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void loginToApplication() {

        homePage = new LoginPage()
                .login(
                        "rahulshettyacademy",
                        "Learning@830$3mK2");
    }

    @Test(description = "Verify Home Page is displayed")
    public void verifyHomePageDisplayed() throws InterruptedException {

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Home page is not displayed.");
    }

    @Test(description = "Verify Product Count")
    public void verifyProductCount() {

        Assert.assertTrue(
                homePage.getProductCount() > 0,
                "Products are not displayed.");
    }

    @Test(description = "Verify Logout Button")
    public void verifyLogoutButtonDisplayed() {

        Assert.assertTrue(
                homePage.isCheckoutButtonDisplayed(),
                "Checkout button is not displayed.");
    }
}