package testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;

import base.BaseTest;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class Login extends BaseTest{
	
	
		
	@Test(dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void login(Hashtable<String,String> data) {
		
		// Excel data binding
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("Login", "login", data.get("Runmode"), excel);
		
		Browser browser = getBrowser(data.get("browser"));
		navigate(browser, Constants.URL);
		click("btn_signup-Login");
		type("txt_emailAddress", data.get("UserName"));
		type("txt_password", data.get("Password"));
		click("btn_login");
		isElementPresent("btn_logout");
		
	}
	

}
