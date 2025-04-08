package pages;

import com.microsoft.playwright.*;

public class CheckoutInfoPage {
    private final Page page;

    public CheckoutInfoPage(Page page) {
        this.page = page;
    }

    public void fillInfo(String first, String last, String zip) {
        page.fill("#first-name", first);
        page.fill("#last-name", last);
        page.fill("#postal-code", zip);
        page.click("#continue");
    }

    public void continueWithoutFilling() {
        page.click("#continue");
    }

    public String getError() {
        return page.locator("[data-test='error']").innerText();
    }
}