package pages;

import org.testng.Assert;

import com.microsoft.playwright.Page;

import base.BasePage;


public class SignInUpPage extends BasePage{

	public SignInUpPage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}
	
		
	public void doLogin(String EmailAddress, String Password) {
		
		type("txt_emailAddress", EmailAddress);
		type("txt_password",Password);
		click("btn_login");
		
		if(isElementPresent("btn_logout")==false) {
			Assert.fail("Login failed");
		};
	}
	
	public void doSignUp(String Name, String EmailAddress) {
		
		type("txt_name", Name);
		type("txt_signupMail", EmailAddress);
		click("btn_signUp");
		System.out.println(page.locator(OR.getProperty("txt_title")).innerText());
		Assert.assertEquals(page.locator(OR.getProperty("txt_title")).innerText(), "ENTER ACCOUNT INFORMATION");
	}
}
