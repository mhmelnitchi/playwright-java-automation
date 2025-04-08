package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import utils.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTests extends BaseTest {

    @Test
    public void testSortByNameAToZ() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(page);

        productPage.sortBy("az");
        List<String> actual = productPage.getProductNames();
        List<String> expected = new ArrayList<>(actual);
        Collections.sort(expected);

        Assert.assertEquals(actual, expected, "Sorting A-Z failed");
    }

    @Test
    public void testSortByNameZToA() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(page);

        productPage.sortBy("za");
        List<String> actual = productPage.getProductNames();
        List<String> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());

        Assert.assertEquals(actual, expected, "Sorting Z-A failed");
    }

    @Test
    public void testSortByPriceLowToHigh() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(page);

        productPage.sortBy("lohi");
        List<Double> actual = productPage.getProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        Collections.sort(expected);

        Assert.assertEquals(actual, expected, "Price low to high sorting failed");
    }

    @Test
    public void testSortByPriceHighToLow() {
        new LoginPage(page).login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage(page);

        productPage.sortBy("hilo");
        List<Double> actual = productPage.getProductPrices();
        List<Double> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());

        Assert.assertEquals(actual, expected, "Price high to low sorting failed");
    }
}
