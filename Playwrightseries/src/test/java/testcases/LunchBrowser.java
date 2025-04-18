package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LunchBrowser {
	
	
	public static void main(String[] args) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		System.out.println(width+"---"+height);
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")));
		BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width, (int)height));
		Page page = browsercontext.newPage();
		page.navigate("http://way2automation.com");
		System.out.println(page.title());
//		page.close();
//		playwright.close();
	}

}
