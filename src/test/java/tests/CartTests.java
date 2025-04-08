package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class CartTests extends BaseTest {

    @Test
    public void testAddSingleItemToCart() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(page);
        inventory.addToCart("sauce-labs-backpack");
        inventory.openCart();
        Assert.assertTrue(page.locator("text=Sauce Labs Backpack").isVisible());
    }

    @Test
    public void testAddMultipleItemsToCart() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(page);
        inventory.addToCart("sauce-labs-backpack");
        inventory.addToCart("sauce-labs-bike-light");
        Assert.assertEquals(page.locator(".shopping_cart_badge").innerText(), "2");
    }

    @Test
    public void testRemoveItemFromCart() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(page);
        inventory.addToCart("sauce-labs-bike-light");
        inventory.openCart();
        inventory.removeFromCart("sauce-labs-bike-light");
        Assert.assertFalse(page.locator("text=Sauce Labs Bike Light").isVisible());
    }
}
