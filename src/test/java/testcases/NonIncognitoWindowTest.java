package testcases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class NonIncognitoWindowTest {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""), new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setExecutablePath(Paths.get("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")));

        Page page = browserContext.newPage();
        page.navigate("http://way2automation.com");
        System.out.println("page.title() => " + page.title());
        Thread.sleep(1000);

        page.navigate("http://google.com");
        page.goBack();
//        page.goBack(new Page.GoBackOptions().setTimeout(500));
        Thread.sleep(1000);

        page.goForward();
//        page.goForward(new Page.GoForwardOptions().setTimeout(500));
//        page.goForward(new Page.GoForwardOptions().setWaitUntil())
        Thread.sleep(1000);

        page.reload();
        Thread.sleep(1000);

        page.close();
        playwright.close();
    }
}
