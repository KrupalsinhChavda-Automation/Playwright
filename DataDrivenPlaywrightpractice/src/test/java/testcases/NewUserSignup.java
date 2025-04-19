package testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import base.BaseTest;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;

public class NewUserSignup extends BaseTest{
	
	
	
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "dp2")
	public void newUserSignup(Hashtable<String,String> data) throws InterruptedException {
		
		// Excel data binding
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		DataUtil.checkExecution("AddNewUser", "newUserSignup", data.get("Runmode"), excel);
		
		Browser browser = getBrowser(data.get("browser"));
		navigate(browser, Constants.URL);
		click("btn_signup-Login");
		type("txt_name", data.get("Name"));
		type("txt_signupMail", data.get("EmailAddress"));
		click("btn_signUp");
		System.out.println(page.locator(BaseTest.OR.getProperty("txt_title")).innerText());
		Assert.assertEquals(page.locator(BaseTest.OR.getProperty("txt_title")).innerText(), "ENTER ACCOUNT INFORMATION");
		
		click("radiobtn_title");
		type("txt_Password", data.get("Password"));
		type("txt_firstName", data.get("FirstName"));
		type("txt_lastName", data.get("LastName"));
		type("txt_address", data.get("Address"));
		select("drp_country", data.get("Country"));
		type("txt_state", data.get("State"));
		type("txt_city", data.get("City"));
		type("num_zipCode", data.get("Zipcode"));
		type("num_MobNumber", data.get("MobileNumber"));
		click("btn_createAccount");
		
		System.out.println(page.locator(BaseTest.OR.getProperty("verify_accCreated")).innerText());
		Assert.assertEquals(page.locator(BaseTest.OR.getProperty("verify_accCreated")).innerText(), "ACCOUNT CREATED!");
		
		click("btn_Continue");
		click("btn_deleteAccount");
		
		System.out.println(page.locator(BaseTest.OR.getProperty("verify_accountDeleted")).innerText());
		Assert.assertEquals(page.locator(BaseTest.OR.getProperty("verify_accountDeleted")).innerText(), "ACCOUNT DELETED!");	
	}

}
