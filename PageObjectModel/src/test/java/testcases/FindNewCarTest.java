package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;
import pages.NewCarPage;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class FindNewCarTest extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void findNewCarTest(Hashtable<String, String> data) throws InterruptedException {

		// Initialize Excel sheet
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("CarWaleSuite", "findNewCarTest", data.get("Runmode"), excel);

		browser = getBrowser(data.get("browser"));
		navigate(browser, Constants.URL);

		HomePage homePage = new HomePage(page);
		homePage.findNewCar();
		NewCarPage newCarPage = new NewCarPage(page);

		if (data.get("carBrand").equals("Kia")) {
			newCarPage.goToKia();
		} else if (data.get("carBrand").equals("Toyota")) {
			newCarPage.goToToyota();
		}else if (data.get("carBrand"). equals("BMW")) {
			newCarPage.goToBMW();
		}else if (data.get("carBrand"). equals("Hyundai")) {
			newCarPage.goToHyundai();
		}
		
		System.out.println(BasePage.careBase.getCarTitle(data.get("carTitle")));
		Assert.assertEquals(BasePage.careBase.getCarTitle(data.get("carTitle")), data.get("carTitle"));
		Thread.sleep(3000);
	}
}
