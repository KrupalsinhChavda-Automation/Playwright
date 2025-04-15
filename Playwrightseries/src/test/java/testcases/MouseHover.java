package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MouseHover {
	
	
	
	public static void main(String[] args) {
		
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://www.way2automation.com/");
		
		page.locator("text= All Courses").nth(0).hover();
		page.locator("#menu-item-27594").click();
	}

}
