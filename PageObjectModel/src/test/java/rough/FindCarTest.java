package rough;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import pages.HomePage;
import pages.NewCarPage;

public class FindCarTest {

	public static void main(String[] args) {


		Playwright plawright =  Playwright.create();
		Browser browser = plawright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://www.carwale.com/");
		
		HomePage homePage = new HomePage(page);
		homePage.findNewCar();
		NewCarPage newCarPage = new NewCarPage(page);
		newCarPage.goToBMW();
		
	}

}
