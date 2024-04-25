package testcases;

import com.microsoft.playwright.*;

public class TestDragAndDrop {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/resources/demos/droppable/default.html");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Locator draggable = page.locator("#draggable");
        Locator droppable = page.locator("#droppable");

        page.mouse().move(draggable.boundingBox().x + draggable.boundingBox().width / 2,
                draggable.boundingBox().y + draggable.boundingBox().height / 2);
        page.mouse().down();
        page.mouse().move(droppable.boundingBox().x + droppable.boundingBox().width / 2,
                droppable.boundingBox().y + droppable.boundingBox().height / 2);
        page.mouse().up();
    }
}
