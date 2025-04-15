package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandalingSlider {
	
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://jqueryui.com/slider/");
		
		
		Locator slider  = page.frameLocator("[class=demo-frame]").locator("//*[@id=\"slider\"]");
		
		page.mouse().move(slider.boundingBox().x+ slider.boundingBox().width/2,slider.boundingBox().y+ slider.boundingBox().height/2 );
		page.mouse().down();
		page.mouse().move(slider.boundingBox().x+ 400,slider.boundingBox().y+ slider.boundingBox().height/2 );
		page.mouse().up();
		
		
	}
	

}
