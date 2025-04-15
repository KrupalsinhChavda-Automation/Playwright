package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php#:~:text=A%20checkbox%20element%20can%20be,the%20HTML%20page%20is%20loaded.");
		
		/*
		 * Locator checkboxs = page.locator("[type='checkbox']");
		 * System.out.println(checkboxs.count());
		 * 
		 * for(int i= 0; i< checkboxs.count();i ++) {
		 * 
		 * checkboxs.nth(i).check();
		 * 
		 * }
		 */
		
		Locator block = page.locator("//div[@class='display']").nth(0);
		Locator blockcheckbox = block.locator("[type='checkbox']");
		
		System.out.println(blockcheckbox.count());
		
		for(int i= 0; i< blockcheckbox.count();i ++) {
			
			blockcheckbox.nth(i).check();
			
		}

	}

}
