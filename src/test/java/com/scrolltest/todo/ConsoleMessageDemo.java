package com.scrolltest.todo;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class ConsoleMessageDemo {

    public static void main(String[] args) {
        ConsoleMessageDemo();
    }

    private static void ConsoleMessageDemo() {
     //https://the-internet.herokuapp.com/javascript_error
        //ConsoleMessage objects are dispatched by page via the Page.onConsoleMessage(handler) event. For each console messages logged in the page there will be corresponding event in the Playwright context.

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setDownloadsPath(Paths.get("src/test/java/com/scrolltest/todo/")).setHeadless(false).setSlowMo(200));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
            Page page = context.newPage();
            page.navigate("https://the-internet.herokuapp.com/javascript_error");
            page.onConsoleMessage(msg -> System.out.println(msg.text()));

// Listen for all console events and handle errors
            page.onConsoleMessage(msg -> {
                if ("error".equals(msg.type()))
                    System.out.println("Error text: " + msg.text());
            });

// Get the next System.out.println
            ConsoleMessage msg = page.waitForConsoleMessage(() -> {
                // Issue console.log inside the page
                page.evaluate("console.log('hello', 42, { foo: 'bar' });");
            });

// Deconstruct console.log arguments
            msg.args().get(0).jsonValue(); // hello
            msg.args().get(1).jsonValue(); // 42
            page.pause();


        }
    }


}
