package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPage {
    private final Page page;
    private final Locator sortDropdown;
    private final Locator productNames;
    private final Locator productPrices;

    public ProductPage(Page page) {
        this.page = page;
        this.sortDropdown = page.locator("[data-test='product-sort-container']");
        this.productNames = page.locator(".inventory_item_name");
        this.productPrices = page.locator(".inventory_item_price");
    }

    public void sortBy(String value) {
        // value: "az", "za", "lohi", "hilo"
        sortDropdown.selectOption(value);
    }

    public List<String> getProductNames() {
        return productNames.allTextContents();
    }

    public List<Double> getProductPrices() {
        List<String> priceStrings = productPrices.allTextContents();
        List<Double> prices = new ArrayList<>();
        for (String price : priceStrings) {
            prices.add(Double.parseDouble(price.replace("$", "").trim()));
        }
        return prices;
    }
}
