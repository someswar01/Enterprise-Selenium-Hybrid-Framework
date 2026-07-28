package dataprovider;

import java.util.List;

import org.testng.annotations.DataProvider;

import models.LoginData;
import utilities.ExcelUtils;
import utilities.JsonUtils;

public final class DataProviderUtils {

    private DataProviderUtils() {
    }

    @DataProvider(name = "loginDataJson")
    public static Object[][] loginDataProvider() {

        List<LoginData> loginData =
                JsonUtils.getLoginData("testdata/loginData.json");

        Object[][] data = new Object[loginData.size()][1];

        for (int i = 0; i < loginData.size(); i++) {
            data[i][0] = loginData.get(i);
        }

        return data;
    }
}