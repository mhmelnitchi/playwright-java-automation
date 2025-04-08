package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;

public class CheckoutTests extends BaseTest {

    @Test
    public void testCheckoutEmptyFields() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        new InventoryPage(page).addToCart("sauce-labs-backpack");
        new InventoryPage(page).openCart();
        new CartPage(page).checkout();
        CheckoutInfoPage infoPage = new CheckoutInfoPage(page);
        infoPage.continueWithoutFilling();
        Assert.assertEquals(infoPage.getError(), "Error: First Name is required");
    }

    @Test
    public void testSuccessfulCheckout() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        new InventoryPage(page).addToCart("sauce-labs-backpack");
        new InventoryPage(page).openCart();
        new CartPage(page).checkout();
        new CheckoutInfoPage(page).fillInfo("John", "Doe", "12345");
        new CheckoutOverviewPage(page).clickFinish();
        Assert.assertTrue(new CheckoutCompletePage(page).getThankYouMessage().contains("Thank you"));
    }
}