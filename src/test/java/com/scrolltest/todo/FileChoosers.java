package com.scrolltest.todo;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChoosers {

    public static void main(String[] args) {
//        upload();
//        download();
    }

    private static void download() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setDownloadsPath(Paths.get("src/test/java/com/scrolltest/todo/")).setHeadless(false).setSlowMo(200));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
            Page page = context.newPage();
            //https://playwright.dev/java/docs/api/class-keyboard
            page.navigate("https://the-internet.herokuapp.com/download");
            Download download = page.waitForDownload(() -> {
                // Perform the action that initiates download
                page.click("[href=\"download/sample.pdf\"]");
            });
// Wait for the download process to complete
            Path path = download.path();
            System.out.println(path.toString());
            page.pause();


        }
    }


    private static void upload() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true));
            Page page = context.newPage();
            //https://playwright.dev/java/docs/api/class-keyboard
            page.navigate("https://the-internet.herokuapp.com/upload");
            FileChooser fileChooser = page.waitForFileChooser(() -> page.click("#file-upload"));
            fileChooser.setFiles(Paths.get("src/test/java/com/scrolltest/todo/sample.pdf"));
            page.click("input:has-text(\"Upload\")");
            page.waitForLoadState();
            System.out.println(page.locator("#uploaded-files").textContent());
            page.pause();


        }
    }
}
