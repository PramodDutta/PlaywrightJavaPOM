package com.scrolltest.pages;

import com.microsoft.playwright.Page;

public class LoginVWOPage {

    private final Page page;

    String usernameBox = "#login-username";
    String passwordBox = "#login-password";
    String loginButton = "#js-login-btn";
    String welcomeProfileButton = "[data-qa='lufexuloga']";

    public LoginVWOPage(Page page) {
        this.page = page;
    }

    public boolean login(String username, String password) {
        boolean isLoginSuccess = false;
        page.fill(usernameBox, username);
        page.fill(passwordBox, password);
        page.click(loginButton);
        page.waitForSelector(welcomeProfileButton).isVisible();
        boolean isEnabled = page.isEnabled("input");
        if (isEnabled) {
            isLoginSuccess = true;
        }
        return isLoginSuccess;
    }
}
