package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandalingAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://vinothqaacademy.com/alert-and-popup/");
	
		page.onDialog(dialog -> {
			dialog.accept();
			System.out.println(dialog.message());
		});
		page.locator("//*[@name='alertbox']").click();
		
	}

}
