package com.scrolltest.todo;

import com.microsoft.playwright.*;

public class SwitchFrameIframe {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            Page page = browser.newPage();
//            page.navigate("https://the-internet.herokuapp.com/iframe");

//            // Iframe Demo
//            FrameLocator  locator = page.frameLocator("#mce_0_ifr");
//            locator.locator("#tinymce").fill("Hello Jo");
//
            page.navigate("https://the-internet.herokuapp.com/nested_frames");
            for (Frame child : page.mainFrame().childFrames()) {
                System.out.println(child.name());
            }

            Frame main_Frame = page.mainFrame();

            Frame frame_top = main_Frame.childFrames().get(0);
            Frame frame_bottom = main_Frame.childFrames().get(1);

            Frame frame_left =   frame_top.childFrames().get(0);
            Frame frame_middle =   frame_top.childFrames().get(1);
            Frame frame_right =   frame_top.childFrames().get(2);


            System.out.println(frame_left.locator("body").innerText());
            System.out.println(frame_middle.locator("body").innerText());
            System.out.println(frame_right.locator("body").innerText());
            System.out.println(frame_bottom.locator("body").innerText());





        }


    }

}
