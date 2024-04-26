package testcases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class TraceViewer {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));

        Page page = context.newPage();
        page.navigate("http://gmail.com");

        //page.locator("#identifierId").type("trainer@way2automation.com");
        //page.locator("[id='identifierId']").type("trainer@way2automation.com");
        //page.type("id=identifierId", "trainer@way2automation.com", new TypeOptions().setDelay(100));
        page.locator("[type=email]").type("trainer@way2automation.com");
        //page.click("text=Next");
        page.click("button:has-text('Next')");
        page.locator("[type=password]").fill("sdfsdfdsf");
        page.click("button:has-text('Next')");
        //System.out.println(page.locator("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span").innerText());

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        page.close();
        context.close();
        playwright.close();

        //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"

    }
}
