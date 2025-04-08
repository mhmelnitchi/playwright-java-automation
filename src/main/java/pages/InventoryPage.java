package pages;

import com.microsoft.playwright.*;

public class InventoryPage {
    private final Page page;

    public InventoryPage(Page page) {
        this.page = page;
    }

    public void addToCart(String itemId) {
        page.locator("button[data-test='add-to-cart-" + itemId + "']").click();
    }

    public void removeFromCart(String itemId) {
        page.locator("button[data-test='remove-" + itemId + "']").click();
    }

    public void openCart() {
        page.click(".shopping_cart_link");
    }
}