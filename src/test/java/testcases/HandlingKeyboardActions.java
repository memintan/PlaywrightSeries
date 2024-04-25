package testcases;

import com.microsoft.playwright.*;

public class HandlingKeyboardActions {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://login.yahoo.com/");

        page.locator("#login-username").type("trainer@way2automation",new Locator.TypeOptions().setDelay(100));
        Thread.sleep(1000);
        page.keyboard().press("Enter");
        Thread.sleep(1000);
        page.goBack();
        page.keyboard().press("Control+A");
        Thread.sleep(1000);
        page.keyboard().press("Control+X");
        Thread.sleep(1000);
        page.keyboard().press("Control+V");
        Thread.sleep(1000);
        page.keyboard().down("Shift");

        for(int i=0; i<3; i++) {

            page.keyboard().press("ArrowLeft");
            Thread.sleep(500);

        }
    }
}
