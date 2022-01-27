package com.Baseframework;

import static com.opencard.utility.UtilityClass.*;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseFrameWork {
	
	public RemoteWebDriver driver;

	@BeforeMethod
	public void setUp() {
		Config conf = new Config();
		this.driver = openBrowser(conf.getBrowserName());
		launchUrl(conf.getAppUrl());

	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.close();
	}

}
