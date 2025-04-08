package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(page.url().contains("inventory"));
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("invalid_user", "wrong_pass");
        Assert.assertTrue(page.locator("[data-test='error']").isVisible());
    }

    @Test
    public void testLockedOutUserLogin_ShowsError() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(page.locator("[data-test='error']").isVisible());
        Assert.assertTrue(page.locator("[data-test='error']").innerText().contains("locked out"));
    }


}