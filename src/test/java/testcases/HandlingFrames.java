package testcases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class HandlingFrames {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://memintan.github.io/portfolio/");
//        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

//        page.frameLocator("#iframeResult").locator("body > button").click(new Locator.ClickOptions().setTimeout(2000));

        System.out.println(page.locator(".summary-container h2").innerText());

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("../PlaywrightSeries/screenshot/screenshot.png")));

//        Locator frames = page.locator("iframe");
//        System.out.println(frames.count());
//
//        for(int i=0; i<frames.count(); i++) {
//            System.out.println(frames.nth(i).getAttribute("id"));
//        }
    }
}
