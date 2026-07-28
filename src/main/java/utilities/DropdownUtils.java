package utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static actions.ElementActions.getElements;

public final class DropdownUtils {

    private DropdownUtils() {
        throw new UnsupportedOperationException(
                "Utility class");
    }

    private static Select getSelect(By locator) {
        WebElement element = WaitUtils.waitForVisibility(locator);
        return new Select(element);
    }

    public static void selectByVisibleText(By locator, String text) {
        getSelect(locator).selectByVisibleText(text);
    }

    public static void selectByValue(By locator, String value) {
        getSelect(locator).selectByValue(value);
    }

    public static void selectByIndex(By locator, int index) {
        getSelect(locator).selectByIndex(index);
    }

    public static String getSelectedOption(By locator) {
        return getSelect(locator)
                .getFirstSelectedOption()
                .getText();
    }

    public static List<String> getAllOptions(By locator) {

        return getSelect(locator)
                .getOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public static int getOptionsCount(By locator) {
        return getSelect(locator).getOptions().size();
    }

    public static List<String> getTexts(By locator) {

        return getElements(locator)
                .stream()
                .map(WebElement::getText)
                .toList();
    }
}