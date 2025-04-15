package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Testframs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://www.w3schools.com/jS/tryit.asp?filename=tryjs_alert");
		
		page.frameLocator("#iframeResult").locator("Body > button").click(new ClickOptions().setTimeout(3000));
		
	

	}

}
