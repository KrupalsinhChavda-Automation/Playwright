package base;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import extentListeners.ExtentListeners;

public class CarBase {

	public Page page;

	public CarBase(Page page) {

		this.page = page;
	}

	public String getCarTitle(String title) {

		try {
			ExtentListeners.getExtent().info("Finding car with titles : " + title);
			return page.locator(BasePage.OR.getProperty("carTitle")).innerText();
		} catch (Throwable t) {

			ExtentListeners.getExtent()
					.fail("Error while finding carw with an title : " + title + " error message is :" + t.getMessage());
			Assert.fail(t.getMessage());
			return null;

		}
		
		
	}
	
	public void getCarNameAndPrice() {
		
		Locator carName = page.locator(BasePage.OR.getProperty("carName"));
		Locator carPrice = page.locator(BasePage.OR.getProperty("carPrice"));
		
		for(int i=0;i<carPrice.count();i++) {
			
			System.out.println(carName.nth(i).innerText()+ "-----car price is"+ carPrice.nth(i).innerText());
		}
	}

}
