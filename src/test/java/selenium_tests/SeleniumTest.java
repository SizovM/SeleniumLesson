package selenium_tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import org.testng.Assert;
import utils.Utils;


public class SeleniumTest extends BaseTest {

    @Test
    public void standardUserCanNotEnterWithWrongPassword() {
        cannotEnter("standard_user", "test123",
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockedOutUserCanNotEnter() {
        cannotEnter("locked_out_user", "secret_sauce",
                "Epic sadface: Sorry, this user has been locked out.");
    }

    private void cannotEnter(String userName, String password, String expectedErrorMessage) {
        Utils.setValue(Utils.findElement(By.id("user-name")), userName);
        Utils.setValue(Utils.findElement(By.id("password")), password);

        Utils.findElement(By.id("login-button")).click();

        By errorMessage = By.cssSelector("h3[data-test='error']");

        Assert.assertTrue(Utils.contentOfElement(errorMessage, expectedErrorMessage),
                "Error message should be " + expectedErrorMessage);
    }
}