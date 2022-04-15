package com.scrolltest.todo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Mouse {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            Page page = browser.newPage();
            //https://playwright.dev/java/docs/api/class-keyboard
            page.navigate("https://vwo.com/free-trial/");
            page.mouse().move(100, 100);
            page.mouse().dblclick(100, 100);
            page.pause();


        }
    }
}
