package com.scrolltest.skip;

import com.microsoft.playwright.*;
import org.testng.Assert;

public class HandleAlerts {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            Page page = browser.newPage();
            page.navigate("https://kitchen.applitools.com/ingredients/alert");
//            page.click("button[onclick='jsConfirm()']");
            page.click("#prompt-button");
            //page.onDialog(dialog -> dialog.accept());
            page.onDialog(dialog ->
            {
                dialog.accept();
                System.out.println(dialog.message());
                System.out.println(page.textContent("#prompt-answer"));
            });
            page.close();

        }
    }

//    static void JSAlert(){
//        page.click("//button[@onclick='jsAlert()']");
//        page.onDialog(dialog -> dialog.dismiss());
//        page.click("button");
//        System.out.println(page.textContent("#result"));
//    }

//    static void JSConfirms(){
//        page.click("button[onclick='jsConfirm()']");
//        //page.onDialog(dialog -> dialog.accept());
//        page.onDialog(dialog -> dialog.dismiss());
//        System.out.println(page.textContent("#result"));
//        page.close();
//    }
}
