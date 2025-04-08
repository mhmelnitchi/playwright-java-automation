package pages;

import com.microsoft.playwright.*;

public class CheckoutCompletePage {
    private final Page page;

    public CheckoutCompletePage(Page page) {
        this.page = page;
    }

    public String getThankYouMessage() {
        return page.locator(".complete-header").innerText();
    }
}
