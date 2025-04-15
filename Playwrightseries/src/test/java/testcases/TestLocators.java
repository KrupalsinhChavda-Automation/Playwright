package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TestLocators {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();

		context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));

		Page page = context.newPage();

		page.navigate("http://gmail.com");

//		page.locator("#identifierId").type("kbckiller3499@gmail.com");
//		page.type("#identifierId", "kbckiller3499@gmail.com", new TypeOptions().setDelay(100));	
		page.locator("[type=email]").type("trainer@way2automation.com");

		page.click("text=Next");
		page.fill("[type=password]", "sdsdf");

		page.click("text=Next");

		System.out.println(page.locator(
				"//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span")
				.innerText());

		// Stop tracing and export it into a zip archive.
		context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));

		page.close();
		context.close();
		playwright.close();

	}

}
