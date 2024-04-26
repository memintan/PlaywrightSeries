package testcases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class CapturingVideos {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("../PlaywrightSeries/videos/")));

        Page page = context.newPage();
        page.navigate("https://memintan.github.io/portfolio/");

        page.locator(".navigation a").nth(1).click();
        Thread.sleep(2000);
        page.locator(".navigation a").nth(2).click();
        Thread.sleep(2000);
        page.locator(".navigation a").nth(3).click();
        Thread.sleep(2000);
        page.locator(".right a").nth(0).click();
        Thread.sleep(2000);

        page.close();
        context.close();
        playwright.close();
    }
}
