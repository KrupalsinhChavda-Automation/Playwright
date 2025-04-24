package testcases;
import org.testng.annotations.Test;
import java.util.Hashtable;
import base.BaseTest;
import pages.HomePage;
import pages.SignInUpPage;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class LoginTest extends BaseTest{

	
	
	
	@Test(dataProviderClass = DataProviders.class , dataProvider = "dp")
	public void loginTest(Hashtable<String, String> data){
		
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("Login", "loginTest", data.get("Runmode"), excel);
		
		
		 browser = getBrowser(data.get("browser"));
		 navigate(browser, Constants.URL);
		 
		 HomePage homePage = new HomePage(page);
		 homePage.goToSignLoginPage();
		 
		 SignInUpPage signPage = new SignInUpPage(page);
		 signPage.doLogin(data.get("UserName"), data.get("Password"));
		
	}
}
