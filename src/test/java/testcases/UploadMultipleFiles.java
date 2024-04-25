package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadMultipleFiles {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_multiple");
        page.frameLocator("#iframeResult").locator("#myFile").setInputFiles(new Path[] {

                Paths.get("./src/test/resources/files/IMG-6873.jpg"),
                Paths.get("./src/test/resources/files/IMG-6874.jpg")});
    }
}
