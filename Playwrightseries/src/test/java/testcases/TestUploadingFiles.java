package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestUploadingFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		page.navigate("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
		
		page.locator("[type=\"file\"]").setInputFiles(Paths.get("./src/test/resources/Files/Xpath+vs+CSS (1).pdf"));

	}

}
