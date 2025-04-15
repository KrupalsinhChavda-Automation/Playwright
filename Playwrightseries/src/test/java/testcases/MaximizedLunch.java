package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizedLunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Playwright playwright = Playwright.create();
		ArrayList<String> arraylist = new ArrayList<>();
		arraylist.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arraylist));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();
		page.navigate("http://way2automation.com");
		System.out.println(page.title());
	}

}
