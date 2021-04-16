package base;

import java.io.File;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FactoryPattern {
	
	public static WebDriver getDriver(BrowserFactory browser)
	{	
		FirefoxProfile profile = new FirefoxProfile();

		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("disable-popup-blocking", false);
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
		dc.setCapability(FirefoxDriver.PROFILE, profile);

		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", System.getProperty("user.dir")+ File.separator +"Download");
		profile.setPreference("browser.download.downloadDir", System.getProperty("user.dir")+ File.separator +"Download");
		profile.setPreference("browser.download.defaultFolder", System.getProperty("user.dir")+ File.separator +"Download");
		profile.setPreference("browser.download.manager.closeWhenDone", true);
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip,text/csv,application/msword,application/excel,application/pdf," +
				"application/vnd.ms-excel,application/msword,application/unknown,application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		
		switch(browser)
		{
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ File.separator+"drivers"+ File.separator  +"geckodriver");
			return new FirefoxDriver();			
		
		case IE:
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ File.separator+"drivers"+ File.separator  +"IEDriverServer.exe");
			return new InternetExplorerDriver();	
			
		case CHROME:
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator +"drivers"+ File.separator +"chromedriver.exe");
			return new ChromeDriver();
			
			/*
			For Chrome headless browser
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("--headless", "window-size=1280,1024", "--no-sandbox"); // Enable for headless option
			return new ChromeDriver();
			*/
			
		default:			
			return null;			
		}		
	}
}
