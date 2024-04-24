package testcases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class TestLocators {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));


        Page page = browser.newPage();
        page.navigate("http://gmail.com");
        System.out.println("page.title() => " + page.title());

//        page.locator("#identifierId").type("trainer@way2automation.com");
//        page.locator("[id='identifierId']").type("trainer@way2automation.com");
//        page.type("#identifierId", "trainer@way2automation.com", new Page.TypeOptions().setDelay(100));

        page.locator("[type=email]").type("trainer@way2automation.com");
        //page.click("text=Next");
        page.click("button:has-text('Next')");
        page.locator("[type=password]").fill("sdfsdfdsf");
        page.click("button:has-text('Next')");
        System.out.println(page.locator(".Ly8vae span").innerText());
    }
}
