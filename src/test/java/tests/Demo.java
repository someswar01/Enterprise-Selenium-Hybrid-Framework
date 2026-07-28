package tests;

import base.BaseTest;
import dataprovider.ExcelDataProvider;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Demo extends BaseTest {

    LoginPage loginPage;
    @Test
    public void verifyApplicationLaunch() {
        Assert.assertEquals(
                DriverManager.getDriver().getTitle(),
                "LoginPage Practise | Rahul Shetty Academy"
        );
    }

//    @Test(dataProvider = "loginData",
//            dataProviderClass = ExcelDataProvider.class)
//    public void verifyLogin(String username,
//                            String password) {
//
//        loginPage.login(username, password);
//
//        // Assertions
//    }
}
