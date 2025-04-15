package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestHandlingLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		page.navigate("https://www.wikipedia.org/");
		
		Locator links = page.locator("a");
		
		System.out.println(links.count());
		
		for(int i=0;i<links.count();i++) {
			
			System.out.println(links.nth(i).getAttribute("href"));
		}
		
		Locator block = page.locator("//*[@id=\"www-wikipedia-org\"]/footer/nav");
		Locator BlockLinks = block.locator("a");
		System.out.println(BlockLinks.count());
		
		for(int i=0;i<BlockLinks.count();i++) {
			
			System.out.println(BlockLinks.nth(i).getAttribute("href"));
		}

	}

}
