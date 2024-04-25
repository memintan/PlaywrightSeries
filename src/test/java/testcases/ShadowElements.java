package testcases;

import com.microsoft.playwright.*;

public class ShadowElements {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("chrome://downloads/");


        page.locator("#searchInput").type("Java");

    }
}
