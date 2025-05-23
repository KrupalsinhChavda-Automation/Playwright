package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import extentListeners.ExtentListeners;

public class BaseTest {

	/*
	 * Playwright instance
	 * 
	 * Browser instance
	 * 
	 * Page instance
	 * 
	 * Set up properties file configs
	 * 
	 * Setup logger class for logs
	 * 
	 * (Playwright specific) thread
	 * 
	 * setup load properties
	 * 
	 * file with @beforesuites (setup)
	 * 
	 * setup browsers instance
	 * 
	 * setup Navigate method
	 * 
	 * Setup all the keywords here
	 * 
	 * Tear Down (AfterMethod/AfterTestsuites)
	 */

	private Playwright playwright;
	public Browser browser;
	protected Page page;
	private Logger log = Logger.getLogger(this.getClass());
	private static ThreadLocal<Playwright> pw = new ThreadLocal<>();
	private static ThreadLocal<Browser> br = new ThreadLocal<>();
	private static ThreadLocal<Page> pg = new ThreadLocal<>();

	public static Playwright getPlaywright() {

		return pw.get();
	}

	public static Browser getBrowser() {

		return br.get();
	}

	public static Page getPage() {

		return pg.get();
	}

	// --------------------- Load properties files --------------------------- //
	@BeforeSuite
	public void setUp() {

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("Test Execution started !!!");
	}	

	// --------------------- setup Browsers instance --------------------------- //
	public Browser getBrowser(String browserName) {

		playwright = Playwright.create();
		pw.set(playwright);

		switch (browserName) {
		case "chrome":
			log.info("Launching Chrome browser");
			return getPlaywright().chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		case "headless":
			log.info("Launching Headless Mode");
			return getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
		case "firefox":
			log.info("Launching Firefox browser");
			return getPlaywright().firefox()
					.launch(new BrowserType.LaunchOptions().setChannel("firefox").setHeadless(false));
		case "webkit":
			log.info("Launching Webkit browser");
			return getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		default:
			throw new IllegalArgumentException();

		}
	}

	// --------------------- setup Navigate method --------------------------- //

	public void navigate(Browser browser, String url) {
		this.browser = browser;
		br.set(browser);
		page = getBrowser().newPage();
		pg.set(page);
		getPage().navigate(url);
		log.info("Navigated to : " + url);

		getPage().onDialog(dialog -> {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dialog.accept();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(dialog.message());
		});
	}

	@AfterMethod
	public void quite() {

		if (getPage() != null) {
			getBrowser().close();
			getPage().close();
//			getPlaywright().close();
		}
	}

	@AfterSuite
	public void quitPlaywright() {
		if (getPage() != null) {
			getPlaywright().close();
		}
	}
}
