package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.*;

import exceptions.FrameworkException;
import logger.FrameworkLogger;

public final class ExcelUtils {
    private final String filePath;
    private Workbook workbook;
    private Sheet sheet;
    private final DataFormatter formatter = new DataFormatter();

    /**
     * Opens the Excel workbook.
     *
     * @param fileName Excel file name inside
     *                 src/test/resources/testdata
     */
    public ExcelUtils(String fileName) {

        try {

            Path path = Paths.get(
                    "src",
                    "test",
                    "resources",
                    "testdata",
                    fileName);

            this.filePath = path.toString();

            FileInputStream fis = new FileInputStream(path.toFile());

            workbook = WorkbookFactory.create(fis);

            FrameworkLogger.info(
                    "Excel workbook loaded : " + fileName);

        } catch (IOException e) {

            throw new FrameworkException(
                    "Unable to load Excel file : " + fileName,
                    e);
        }
    }
    /**
     * Selects the sheet.
     *
     * @param sheetName Sheet name
     */
    public void setSheet(String sheetName) {

        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {

            throw new FrameworkException(
                    "Sheet not found : " + sheetName);
        }

        FrameworkLogger.info(
                "Using Sheet : " + sheetName);
    }

    /**
     * Returns currently selected sheet.
     */
    public Sheet getSheet() {
        return sheet;
    }

    /**
     * Returns workbook.
     */
    public Workbook getWorkbook() {
        return workbook;
    }

    /**
     * Returns DataFormatter.
     */
    public DataFormatter getFormatter() {
        return formatter;
    }

    /**
     * Returns the specified row from the current sheet.
     *
     * @param rowNumber Row index (0-based)
     * @return Row object
     */
    public Row getRow(int rowNumber) {

        if (sheet == null) {
            throw new FrameworkException(
                    "Sheet is not selected. Call setSheet() before accessing data.");
        }

        Row row = sheet.getRow(rowNumber);

        if (row == null) {
            throw new FrameworkException(
                    "Row not found : " + rowNumber);
        }

        return row;
    }

    /**
     * Returns the specified cell.
     *
     * @param row Row index
     * @param column Column index
     * @return Cell object
     */
    public Cell getCell(int row, int column) {

        Row currentRow = getRow(row);

        Cell cell = currentRow.getCell(column);

        if (cell == null) {
            throw new FrameworkException(
                    "Cell not found at Row : "
                            + row
                            + " Column : "
                            + column);
        }

        return cell;
    }

    /**
     * Returns cell value as String.
     * Works for String, Number, Date, Boolean and Formula cells.
     *
     * @param row Row index
     * @param column Column index
     * @return Cell value as String
     */
    public String getCellData(int row, int column) {

        String value =
                formatter.formatCellValue(getCell(row, column));

        FrameworkLogger.info(
                "Reading Cell ["
                        + row
                        + ","
                        + column
                        + "] : "
                        + value);

        return value;
    }

    /**
     * Returns total number of rows in the current sheet.
     *
     * @return Row count
     */
    public int getRowCount() {

        if (sheet == null) {
            throw new FrameworkException(
                    "Sheet is not selected.");
        }

        return sheet.getLastRowNum() + 1;
    }

    /**
     * Returns total number of columns in the header row.
     *
     * @return Column count
     */
    public int getColumnCount() {

        if (sheet == null) {
            throw new FrameworkException(
                    "Sheet is not selected.");
        }

        Row row = getRow(0);

        return row.getLastCellNum();
    }

    /**
     * Writes data into a cell.
     *
     * @param row Row index
     * @param column Column index
     * @param value Value to write
     */
    public void setCellData(int row, int column, String value) {

        Row currentRow = sheet.getRow(row);

        if (currentRow == null) {
            currentRow = sheet.createRow(row);
        }

        Cell cell = currentRow.getCell(column);

        if (cell == null) {
            cell = currentRow.createCell(column);
        }

        cell.setCellValue(value);

        FrameworkLogger.info(
                "Writing Cell [" +
                        row +
                        "," +
                        column +
                        "] : " +
                        value);
    }

    /**
     * Saves all changes to the Excel workbook.
     */
    public void saveWorkbook() {

        try (FileOutputStream fos =
                     new FileOutputStream(filePath)) {

            workbook.write(fos);

            FrameworkLogger.info(
                    "Workbook saved successfully.");

        } catch (IOException e) {

            throw new FrameworkException(
                    "Unable to save workbook.",
                    e);
        }
    }

    /**
     * Closes the workbook.
     */
    public void closeWorkbook() {

        try {

            workbook.close();

            FrameworkLogger.info(
                    "Workbook closed successfully.");

        } catch (IOException e) {

            throw new FrameworkException(
                    "Unable to close workbook.",
                    e);
        }
    }

    /**
     * Creates a new sheet if it does not already exist.
     *
     * @param sheetName Sheet name
     */
    public void createSheet(String sheetName) {

        if (workbook.getSheet(sheetName) == null) {

            workbook.createSheet(sheetName);

            FrameworkLogger.info(
                    "Sheet created : " + sheetName);

        } else {

            FrameworkLogger.warn(
                    "Sheet already exists : " + sheetName);
        }
    }

    /**
     * Returns all Excel data except the header row
     * in Object[][] format for TestNG DataProvider.
     *
     * @return Excel data as Object[][]
     */
    public Object[][] getDataAs2DArray() {

        int totalRows = getRowCount();
        int totalColumns = getColumnCount();

        Object[][] data =
                new Object[totalRows - 1][totalColumns];

        for (int row = 1; row < totalRows; row++) {

            for (int column = 0; column < totalColumns; column++) {

                data[row - 1][column] =
                        getCellData(row, column);
            }
        }

        FrameworkLogger.info(
                "Excel data loaded successfully. Rows : "
                        + (totalRows - 1));

        return data;
    }

}