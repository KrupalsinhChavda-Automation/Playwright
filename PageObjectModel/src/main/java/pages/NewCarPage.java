package pages;

import com.microsoft.playwright.Page;

public class NewCarPage {

	public Page page;

	public NewCarPage(Page page) {

		this.page = page;
	}

	public void goToHyundai() {

		page.click("//img[@title='Hyundai Cars']");
	}

	public void goToToyota() {

		page.click("//div[normalize-space()='Toyota']");
	}

	public void goToKia() {

		page.click("//img[@title='Kia Cars']");
	}
	
	public void goToBMW() {

		page.click("//img[@title='BMW Cars']");
	}
}
