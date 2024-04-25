package testcases;

import com.microsoft.playwright.*;

public class TestSliders {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/resources/demos/slider/default.html");

        Locator slider = page.locator("//*[@id='slider']/span");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        page.mouse().move(slider.boundingBox().x + slider.boundingBox().width/2, slider.boundingBox().y+slider.boundingBox().height/2);
        page.mouse().down();
        page.mouse().move(slider.boundingBox().x + 400, slider.boundingBox().y+slider.boundingBox().height/2);
        page.mouse().up();
    }
}
