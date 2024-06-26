package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

    public static void main(String[] args) throws InterruptedException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        System.out.println(width + "-" + height);

        Playwright playwright = Playwright.create();

        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome")));
//        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
        Page page = browserContext.newPage();
        page.navigate("http://way2automation.com");
        System.out.println("page.title() => " + page.title());
        Thread.sleep(2000);
        page.close();
        playwright.close();
    }

}