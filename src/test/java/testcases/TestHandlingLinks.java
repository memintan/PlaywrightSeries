package testcases;

import com.microsoft.playwright.*;

public class TestHandlingLinks {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        System.out.println("page.title() => " + page.title());

        Locator links = page.locator("a");

        System.out.println(links.count());

        for(int i=0; i<links.count(); i++) {

            System.out.println(links.nth(i).innerText()+"---URL: ----"+links.nth(i).getAttribute("href"));

        }

        Locator block = page.locator("footer nav");

        Locator blockLinks = block.locator("a");

        System.out.println("----Printing links from the block------");

        System.out.println(blockLinks.count());

        for(int i=0; i<blockLinks.count(); i++) {

            System.out.println(blockLinks.nth(i).innerText()+"---URL: ----"+blockLinks.nth(i).getAttribute("href"));

        }
        //block.locator("#input").nth(2).click();
    }
}
