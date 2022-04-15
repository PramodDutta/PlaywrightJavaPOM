package com.scrolltest.done;

import com.microsoft.playwright.*;

public class FrameDemo {

    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(200));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();

//            page.navigate("https://the-internet.herokuapp.com/iframe");
//
//            FrameLocator frameLocator = page.frameLocator("#mce_0_ifr");
//            frameLocator.locator("#tinymce").fill("Hello Ji");
//            page.pause();

            page.navigate("https://the-internet.herokuapp.com/nested_frames");
            for(Frame childFrame : page.mainFrame().childFrames()){
                System.out.println(childFrame.name());
            }

            Frame main_frame = page.mainFrame();
            Frame top_frame = main_frame.childFrames().get(0);
            Frame bottom_frame = main_frame.childFrames().get(1);

            bottom_frame.addScriptTag();
            Frame left_frame = top_frame.childFrames().get(0);
            Frame middle_frame = top_frame.childFrames().get(1);
            Frame right_frame = top_frame.childFrames().get(2);

            System.out.println(left_frame.locator("body").innerText());
            System.out.println(middle_frame.locator("body").innerText());
            System.out.println(right_frame.locator("body").innerText());


        }
        catch (Exception e){
            System.out.println(e.toString());
        }



    }
}
