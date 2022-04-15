package com.scrolltest.done;

import com.microsoft.playwright.*;

public class KeyboardMJS {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

            page.navigate("https://vwo.com/free-trial/");

//            page.mouse().move(100,100);
//            page.click("#page-v1-step1-email");
//            page.keyboard().type("name@yourcompany.com");
//            page.keyboard().press("Enter");
//            page.pause();

            JSHandle jsHandle = page.evaluateHandle("window.scrollTo(0,344)");






        }
    }
}
