package testcases;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page = browser.newPage();
		
		page.navigate("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple");
		
		page.frameLocator("#iframeResult").locator("#files").setInputFiles(new Path[] {
				
				Paths.get("./src/test/resources/Files/Xpath+vs+CSS (1).pdf"),
				Paths.get("./src/test/resources/Files/Xpath+vs+CSS+-+Everything+you+need+to+know+about+XPath+and+CSS.docx.pdf")
		});
		
		

	}

}
