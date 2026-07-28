package dataprovider;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtils;

public final class ExcelDataProvider {

    private ExcelDataProvider() {
    }

    @DataProvider(name = "loginDataWithExcel")
    public static Object[][] loginData() {

        ExcelUtils excel =
                new ExcelUtils("LoginData.xlsx");

        excel.setSheet("Login");

        Object[][] data =
                excel.getDataAs2DArray();

        excel.closeWorkbook();

        return data;
    }
}