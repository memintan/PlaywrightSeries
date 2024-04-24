package testcases;

import com.microsoft.playwright.*;

public class HandlingFrames {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

        page.frameLocator("#iframeResult").locator("body > button").click(new Locator.ClickOptions().setTimeout(2000));
        Locator frames = page.locator("iframe");
        System.out.println(frames.count());

        for(int i=0; i<frames.count(); i++) {
            System.out.println(frames.nth(i).getAttribute("id"));
        }
    }
}
