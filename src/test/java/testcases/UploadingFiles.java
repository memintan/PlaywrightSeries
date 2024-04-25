package testcases;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class UploadingFiles {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        page.locator("#register_form > fieldset:nth-child(9) > input[type=file]").setInputFiles(Paths.get("../PlaywrightSeries/src/test/resources/files/tractor.jpg"));
    }


}
