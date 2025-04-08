package pages;

import com.microsoft.playwright.*;

public class CheckoutOverviewPage {
    private final Page page;

    public CheckoutOverviewPage(Page page) {
        this.page = page;
    }

    public void clickFinish() {
        page.click("#finish");
    }
}
