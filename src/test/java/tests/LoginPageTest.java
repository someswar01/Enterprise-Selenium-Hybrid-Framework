package tests;



    //    @Test(description = "Verify Login Page Title")
//    public void verifyLoginPageTitle() {
//
//        LoginPage loginPage = new LoginPage();
//
//        Assert.assertEquals(
//                loginPage.getLoginPageTitle(),
//                "LoginPage Practise | Rahul Shetty Academy",
//                "Login page title is incorrect.");
//    }
//
//    @Test(description = "Verify Login Page URL")
//    public void verifyLoginPageUrl() {
//
//        LoginPage loginPage = new LoginPage();
//
//        Assert.assertTrue(
//                loginPage.getLoginPageUrl().contains("loginpagePractise"),
//                "Login page URL is incorrect.");
//    }
//
//    @Test(description = "Verify Username Textbox")
//    public void verifyUsernameTextbox() {
//
//        LoginPage loginPage = new LoginPage();
//
//        Assert.assertTrue(
//                loginPage.isUsernameDisplayed(),
//                "Username textbox is not displayed.");
//    }
//
//
//    @Test(description = "Verify successful login")
//    public void verifySuccessfulLogin() {
//
//        HomePage homePage = new LoginPage()
//                .login(
//                        ConfigReader.getUsername(),
//                        ConfigReader.getPassword());
//
//        Assert.assertTrue(
//                homePage.getProductCount() > 0,
//                "Products are not displayed after login.");
//
//        Assert.assertTrue(
//                homePage.isCheckoutButtonDisplayed(),
//                "Checkout button is not displayed.");
//
//
//    }


//    @Test(description = "Verify successful login")
//    public void verifySuccessfulLogin() {
//
//        Assert.fail("Retry Analyzer Validation");
//    }
//
//    @Retry
//    @Test(description = "Verify successful login1")
//    public void verifySuccessfulLogin1() {
//
//        Assert.fail("Retry Analyzer Validation1");
//    }

import annotations.Retry;
import base.BaseTest;
import dataprovider.DataProviderUtils;
import dataprovider.ExcelDataProvider;
import driver.DriverManager;
import models.LoginData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ScreenshotUtils;
import utils.AssertionUtils;

//    @Test
//    public void edgeTest() {
//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver();
//        driver.get("https://google.com");
//        driver.quit();
//    }
public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void initializePages() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Retry
    @Test(description = "Verify Successful Login")
    public void verifySuccessfulLogin() throws InterruptedException {

        loginPage.login(
                "rahulshettyacademy",
                "Learning@830$3mK2");


        Assert.assertTrue(
                homePage.isHomePageLoaded(),
                "Home page is not displayed after successful login.");

    }

    @Test(description = "Verify Invalid Username")
    public void verifyInvalidUsername() {

        String actualError = loginPage
                .loginExpectingFailure(
                        "invalidUser",
                        "Learning@830$3mK2")
                .getLoginErrorMessage();

        Assert.assertEquals(
                actualError,
                "Incorrect username/password.");
    }

    @Test(description = "Verify Invalid Password")
    public void verifyInvalidPassword() {

        String actualError = loginPage
                .loginExpectingFailure(
                        "rahulshettyacademy",
                        "WrongPassword")
                .getLoginErrorMessage();

        Assert.assertEquals(
                actualError,
                "Incorrect username/password.");
    }

    @Test(dataProvider = "loginDataWithExcel",
            dataProviderClass = ExcelDataProvider.class)
    public void verifyLoginDataWithExcel(String username,
                            String password) {

        loginPage.login(username, password);

        Assert.assertTrue(
                homePage.isHomePageLoaded(),
                "Home page was not loaded successfully.");

        Assert.assertEquals(
                homePage.getPageTitle(),
                "ProtoCommerce",
                "Page title validation failed.");

        Assert.assertEquals(
                homePage.getCurrentUrl(),
                "https://rahulshettyacademy.com/angularpractice/shop",
                "URL validation failed.");
    }

    @Test(dataProvider = "loginDataJson",
            dataProviderClass = DataProviderUtils.class)
    public void verifyLoginDataWithJson(LoginData data) {

        if ("SUCCESS".equalsIgnoreCase(data.getExpectedResult())) {

            HomePage homePage = new LoginPage()
                    .login(
                            data.getUsername(),
                            data.getPassword());

            Assert.assertTrue(
                    homePage.getProductCount() > 0,
                    "Successful login failed.");

        } else {

            LoginPage loginPage = new LoginPage();

            loginPage.loginExpectingFailure(
                    data.getUsername(),
                    data.getPassword());

            Assert.assertFalse(
                    loginPage.getLoginErrorMessage().isEmpty(),
                    "Expected error message was not displayed.");
        }
    }
//
//    @Retry
//    @Test(description = "Verify Successful Login with soft assert")
//    public void verifySuccessfulLogin1() {
//
//        loginPage.login(
//                "rahulshettyacademy",
//                "Learning@830$3mK2");
//
//        String actualTitle = DriverManager.getDriver().getTitle();
//        String expectedTitle = "ProtoCommerce";
//
//        // Validate title
//        AssertionUtils.getSoftAssert()
//                .assertEquals(
//                        actualTitle,
//                        expectedTitle,
//                        "Page title validation failed.");
//
//        // Validate home page visibility
//        AssertionUtils.getSoftAssert()
//                .assertTrue(
//                        homePage.isHomePageDisplayed(),
//                        "Home page is not displayed after successful login.");
//
//        // Validate product count
//        AssertionUtils.getSoftAssert()
//                .assertTrue(
//                        homePage.getProductCount() > 0,
//                        "Products are not displayed on the home page.");
//    }

}