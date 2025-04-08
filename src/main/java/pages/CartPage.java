package pages;

import com.microsoft.playwright.*;

public class CartPage {
    private final Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public void checkout() {
        page.click("#checkout");
    }
}