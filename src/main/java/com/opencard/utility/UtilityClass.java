package com.opencard.utility;

import java.time.Duration;

import javax.management.loading.PrivateClassLoader;
import javax.print.attribute.standard.RequestingUserName;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass {

	public static RemoteWebDriver driver;

	public static WebDriverWait wait;
	
	private static final Logger LOG = Logger.getLogger(UtilityClass.class);

	public static RemoteWebDriver openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			LOG.error("Inavlid browser selection " + browserName);
		}
		
		wait=new WebDriverWait(driver, Duration.ofMillis(3000));
		return driver;

	}

	public static void launchUrl(String url) {
		driver.get(url);
		LOG.info("Browser launch: ");
	}

	public static void waitFor(long duration) {

		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public static void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();;

	}
	
	public static void click(String locator) {
		String parts[]=locator.split("##");
		getWebElement(parts[0], parts[1]).click();
	}
	
	public static void enterText(String locator,String textToEnter) {
		String parts[]=locator.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);
	}

	public static WebElement getWebElement(String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("CSS")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			return driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			return driver.findElement(By.className(locatorValue));
		}return null;

	}

	public static void enterText(String locatorType, String locatorValue,String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}
}
