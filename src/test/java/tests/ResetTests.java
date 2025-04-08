package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class ResetTests extends BaseTest {

    @Test
    public void testResetAppState() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(page);
        inventory.addToCart("sauce-labs-backpack");
        page.click("#react-burger-menu-btn");
        page.click("#reset_sidebar_link");
        Assert.assertFalse(page.locator(".shopping_cart_badge").isVisible());
    }
}
