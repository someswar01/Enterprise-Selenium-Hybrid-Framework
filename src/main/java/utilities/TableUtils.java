package utilities;

import driver.DriverManager;
import logger.FrameworkLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public final class TableUtils {

    private TableUtils() {
        throw new UnsupportedOperationException(
                "TableUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Returns all rows in the table.
     */
    private static List<WebElement> getRows(By tableLocator) {

        return WaitUtils.waitForVisibility(tableLocator)
                .findElements(By.tagName("tr"));
    }

    /**
     * Returns row count.
     */
    public static int getRowCount(By tableLocator) {

        int rows = getRows(tableLocator).size();

        FrameworkLogger.info("Table Row Count : " + rows);

        return rows;
    }

    /**
     * Returns column count.
     */
    public static int getColumnCount(By tableLocator) {

        List<WebElement> rows = getRows(tableLocator);

        if (rows.isEmpty()) {
            return 0;
        }

        int columns = rows.getFirst()
                .findElements(By.xpath("./th|./td"))
                .size();

        FrameworkLogger.info("Table Column Count : " + columns);

        return columns;
    }

    /**
     * Returns cell data.
     */
    public static String getCellData(By tableLocator,
                                     int row,
                                     int column) {

        String value = getRows(tableLocator)
                .get(row)
                .findElements(By.xpath("./th|./td"))
                .get(column)
                .getText()
                .trim();

        FrameworkLogger.info("Cell Value : " + value);

        return value;
    }

    /**
     * Returns complete row.
     */
    public static List<String> getRowData(By tableLocator,
                                          int row) {

        List<String> data = new ArrayList<>();

        for (WebElement cell :
                getRows(tableLocator)
                        .get(row)
                        .findElements(By.xpath("./th|./td"))) {

            data.add(cell.getText().trim());
        }

        return data;
    }

    /**
     * Returns complete column.
     */
    public static List<String> getColumnData(By tableLocator,
                                             int column) {

        List<String> values = new ArrayList<>();

        for (WebElement row : getRows(tableLocator)) {

            values.add(
                    row.findElements(By.xpath("./th|./td"))
                            .get(column)
                            .getText()
                            .trim());
        }

        return values;
    }

    /**
     * Checks if row exists.
     */
    public static boolean isRowPresent(By tableLocator,
                                       String text) {

        return getRows(tableLocator)
                .stream()
                .anyMatch(r -> r.getText().contains(text));
    }

    /**
     * Returns row number.
     */
    public static int getRowNumber(By tableLocator,
                                   String text) {

        List<WebElement> rows = getRows(tableLocator);

        for (int i = 0; i < rows.size(); i++) {

            if (rows.get(i).getText().contains(text)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Clicks a cell.
     */
    public static void clickCell(By tableLocator,
                                 int row,
                                 int column) {

        getRows(tableLocator)
                .get(row)
                .findElements(By.xpath("./th|./td"))
                .get(column)
                .click();

        FrameworkLogger.info("Clicked Cell : " + row + "," + column);
    }

    /**
     * Clicks complete row.
     */
    public static void clickRow(By tableLocator,
                                int row) {

        getRows(tableLocator)
                .get(row)
                .click();

        FrameworkLogger.info("Clicked Row : " + row);
    }

    /**
     * Returns complete table.
     */
    public static List<List<String>> getTableData(By tableLocator) {

        List<List<String>> table = new ArrayList<>();

        for (int i = 0; i < getRowCount(tableLocator); i++) {

            table.add(getRowData(tableLocator, i));
        }

        return table;
    }

    /**
     * Returns row as Map.
     */
    public static Map<String, String> getRowAsMap(By tableLocator,
                                                  int row) {

        Map<String, String> map = new LinkedHashMap<>();

        List<String> headers = getRowData(tableLocator, 0);

        List<String> values = getRowData(tableLocator, row);

        for (int i = 0; i < headers.size(); i++) {

            map.put(headers.get(i), values.get(i));
        }

        return map;
    }

    /**
     * Prints table.
     */
    public static void printTable(By tableLocator) {

        getTableData(tableLocator)
                .forEach(System.out::println);
    }
}