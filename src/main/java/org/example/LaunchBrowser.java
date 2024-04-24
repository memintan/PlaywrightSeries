package org.example;

import com.microsoft.playwright.*;

import java.awt.*;

public class LaunchBrowser {

    public static void main(String[] args) throws InterruptedException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        System.out.println(width + "-" + height);

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
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