package pages;

import com.microsoft.playwright.Page;

import base.BasePage;

public class HomePage extends BasePage{

	public HomePage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}
	
	
	public void goToSignLoginPage(){
		
		
		click("btn_signup-Login");
		
	}
	

}
