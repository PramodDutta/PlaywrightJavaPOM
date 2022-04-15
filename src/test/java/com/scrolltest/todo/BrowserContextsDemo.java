package com.scrolltest.todo;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BrowserContextsDemo {

    public static void main(String[] args) {
        BrowserContextsDemo();
    }

    private static void BrowserContextsDemo() {
        // BrowserContexts provide a way to operate multiple independent browser sessions.
        // Playwright allows creating "incognito" browser contexts with Browser.newContext([options]) method. "Incognito" browse

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setDownloadsPath(Paths.get("src/test/java/com/scrolltest/todo/")).setHeadless(false).setSlowMo(200));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
            Page page = context.newPage();
            page.navigate("https://the-internet.herokuapp.com/download");
            page.pause();


        }
    }


}
