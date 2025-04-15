package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestResizable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://jqueryui.com/resizable/");
		
		
		Locator slider  = page.frameLocator("[class=demo-frame]").locator("[class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']");
		
		page.mouse().move(slider.boundingBox().x+ slider.boundingBox().width/2,slider.boundingBox().y+ slider.boundingBox().height/2 );
		page.mouse().down();
		page.mouse().move(slider.boundingBox().x+ 400,slider.boundingBox().y+ 500 );
		page.mouse().up();
		
		

	}

}
