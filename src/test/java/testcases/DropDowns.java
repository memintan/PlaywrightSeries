package testcases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class DropDowns {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        System.out.println("page.title() => " + page.title());

        //select by value
        page.selectOption("#searchLanguage", "tr");
        Thread.sleep(2000);
        //select by text
        page.selectOption("#searchLanguage", "Српски / Srpski");
        page.selectOption("#searchLanguage", new SelectOption().setLabel("Српски / Srpski"));

        //select by index
        page.selectOption("#searchLanguage", new SelectOption().setIndex(9));

//        Locator values = page.locator("select option");
//        System.out.println("values => " + values.count());
//
//        for (int i = 0; i < values.count(); i++) {
//            System.out.println(values.nth(i).innerText() + " --- " + values.nth(i).getAttribute("lang"));
//        }

        List<ElementHandle> values = page.querySelectorAll("select option");
        System.out.println(values.size());

        for (ElementHandle value: values){
            System.out.println(value.innerText() + " is shown as -> " + value.getAttribute("lang"));
        }

        page.close();
        playwright.close();

    }
}
