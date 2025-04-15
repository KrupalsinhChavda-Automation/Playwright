package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class CapturingVideos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		
		Page page = context.newPage();
		page.navigate("https://www.selenium.dev/downloads/");
		
		
		page.locator("//h1[text()='Downloads']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./Screenshots/Screenshot_Elements.png")));

		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/Screenshot.png")));
		
		page.close();
		context.close();
		playwright.close();

	}

}
