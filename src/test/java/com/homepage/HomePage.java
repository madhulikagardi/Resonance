
package com.homepage;

import static com.opencard.utility.UtilityClass.*;

import java.util.Properties;

import com.locator.Locator;
import com.opencard.utility.PropertiesUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Baseframework.BaseFrameWork;

public class HomePage extends BaseFrameWork {
	
	
	

	@Test
	public void toNavigateFromShoopingPageToHomePage() throws InterruptedException {

		waitFor(3000);
		click(Locator.homepage_SearchBox);
		enterText(Locator.homepage_SearchBox, "Palm Treo Pro");
		click(Locator.homepage_searhBtn);
		waitFor(3000);
		//PropertiesUtil prop = new PropertiesUtil();
		//String dir=System.getProperty("user.dir")+"/src/main/resources/OR.properties";
		//click(prop.getLocator("searchPage_addToCart")[0],prop.getLocator("searchPage_addToCart")[1]);
		click(Locator.searchPage_addToCart);
		waitFor(3000);
		click(Locator.serachPage_shoppingCartlink);
		waitFor(3000);
		click(Locator.searchPage_countinueShoppingBtn);

		String Expected = "Your Store";
		String Actual = driver.getTitle();

		Assert.assertEquals(Actual, Expected);

	}

	// @Test
	public void toVerifyNavigatetoHomePageClickingOnLogo() {

		//click(LocatorType.css, "div.col-sm-4 div h1 a");

		String expected = "Your Store";
		String actual = driver.getTitle();

		Assert.assertEquals(actual, expected);

	}

	//@Test
	public void verifyNavigatetoHomePageFromCategoryPage() {

	//	click(LocatorType.css, "div.collapse.navbar-collapse.navbar-ex1-collapse>ul>li:nth-child(1)>a");

		String expected = "Your Store";
		String actual = driver.getTitle();

		Assert.assertEquals(actual, expected);

	}

}
