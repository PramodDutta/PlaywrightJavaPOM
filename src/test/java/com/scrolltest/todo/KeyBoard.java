package com.scrolltest.todo;

import com.microsoft.playwright.*;

public class KeyBoard {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            Page page = browser.newPage();
            //https://playwright.dev/java/docs/api/class-keyboard
            page.navigate("https://vwo.com/free-trial/");
            page.click("[placeholder=\"name@yourcompany.com\"]");
            page.keyboard().type("name@yourcompany.com");

            //F1 - F12, Digit0- Digit9, KeyA- KeyZ, Backquote, Minus, Equal, Backslash, Backspace, Tab, Delete, Escape, ArrowDown, End, Enter, Home, Insert, PageDown, PageUp, ArrowRight, ArrowUp, etc.
            page.keyboard().press("Enter");
            page.pause();

        }
    }
}
