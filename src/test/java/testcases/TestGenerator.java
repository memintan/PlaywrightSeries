package testcases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestGenerator {

    //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
//            page.navigate("https://demo.playwright.dev/todomvc/");
//            page.navigate("https://demo.playwright.dev/todomvc/#/");
            page.navigate("http://memintan.github.io/portfolio/");

//            page.getByLabel("Email or phone").click();
//            page.getByLabel("Email or phone").fill("trainer@way2automation.com");
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
//            page.getByLabel("Enter your password").fill("Abc1234");
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
//            assertThat(page.getByText("Wrong password. Try again or")).isVisible();
//            assertThat(page.locator("form")).containsText("Wrong password. Try again or click Forgot password to reset it.");
//            System.out.println(page.getByText("Wrong password. Try again or").innerText());


            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("AboutMe")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Projects")).click();
            page.locator("section div").filter(new Locator.FilterOptions().setHasText("AgilePro CRM | Tysons, VA")).getByRole(AriaRole.BUTTON).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact")).click();
            page.getByPlaceholder("Your Name").click();
            page.getByPlaceholder("Your Name").fill("myukseldev@gmail.com");
            page.getByPlaceholder("Your Email").click();
            page.getByPlaceholder("Your Email").fill("myukseldev@gmail.com");
            page.getByPlaceholder("Your Message").click();
            page.getByPlaceholder("Your Message").fill("naber dayi");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Send")).click();
            assertThat(page.locator(".thanks")).isVisible();
        }

    }
}
