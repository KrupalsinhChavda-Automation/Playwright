package testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SignInUpPage;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class UserSignupTest extends BaseTest{
	
	
	@Test(dataProviderClass = DataProviders.class , dataProvider = "dp2")
	public void userSignupTest(Hashtable<String, String> data){
		
		
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		DataUtil.checkExecution("AddNewUser", "userSignupTest", data.get("Runmode"), excel);
		
		
		 browser = getBrowser(data.get("browser"));
		 navigate(browser, Constants.URL);
		 
		 HomePage homePage = new HomePage(page);
		 homePage.goToSignLoginPage();
		 
		 SignInUpPage signUp = new SignInUpPage(page);
		 signUp.doSignUp(data.get("Name"), data.get("EmailAddress"));
	
	}

}
