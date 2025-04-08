// -------- LogoutTests.java --------
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LogoutTests extends BaseTest {

    @Test
    public void testLogout() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        page.click("#react-burger-menu-btn");
        page.click("#logout_sidebar_link");
        Assert.assertTrue(page.locator("#login-button").isVisible());
    }
}
