package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GoBackOptions;
import com.microsoft.playwright.Page.GoForwardOptions;
import com.microsoft.playwright.Playwright;

public class NonIncognitoModeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
		BrowserContext context = playwright.chromium().launchPersistentContext(
				Paths.get("C:\\Users\\krupa\\AppData\\Local\\Google\\Chrome\\User Data\\Default"),
				new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
		Page page = context.newPage();
		page.navigate("http://way2automation.com");
		System.out.println(page.title());

		page.navigate("http://google.com");

		page.goBack(new GoBackOptions().setTimeout(5000));

		page.reload();
		
		page.goForward(new GoForwardOptions().setTimeout(5000));

	}

}
