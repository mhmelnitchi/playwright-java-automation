package pages;

import com.microsoft.playwright.*;

public class LoginPage {
    private final Page page;
    private Locator username;
    private Locator password;
    private Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.username = page.locator("#user-name");
        this.password = page.locator("#password");
        this.loginButton = page.locator("#login-button");
    }

    public void login(String user, String pass) {
        username.fill(user);
        password.fill(pass);
        loginButton.click();
    }
}
