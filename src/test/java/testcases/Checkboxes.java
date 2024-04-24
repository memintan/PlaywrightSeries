package testcases;

import com.microsoft.playwright.*;

import java.util.concurrent.TimeoutException;

public class Checkboxes {
    public static void main(String[] args) throws TimeoutException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://app.endtest.io/guides/docs/how-to-test-checkboxes/");

//        Locator block = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]");
//        Locator block = page.locator("body > div.navPusher > div > div.container.mainContainer.docsContainer > div > div.post > article > div > span > p:nth-child(4)");
        Locator block = page.locator("span p").nth(2);
        Locator checkboxes = block.locator("[type='checkbox']");

        for(int i=0; i<checkboxes.count(); i++) {

            if (checkboxes.nth(i).isChecked())
                continue;
            checkboxes.nth(i).click();

        }

        System.out.println(checkboxes.count());

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

        page.close();

        browser.close();

        playwright.close();
    }
}


