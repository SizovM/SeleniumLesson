package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_tests.BaseTest;
import java.time.Duration;

public class Utils

{

    public static boolean contentOfElement(By locator, String expectedText) {
        return waiting(5).until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public static void setValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public static WebElement findElement(By locator) {
        return waiting(5).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private static boolean isElementPresent(By locator) {
        return !(driver().findElements(locator).isEmpty());
    }

    private static WebDriverWait waiting(int timeToWait) {
        return new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(timeToWait));
    }

    private static WebDriver driver() {
        return BaseTest.getDriver();
    }
}