package com.ijmeet.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinMeetingHomepage {
	
	
	
	@FindBy(css= "ul.navbar-nav.ml-auto li:nth-child(1) a")
	public WebElement joinMeeting;
	
	public void clickOnjoinMeeting() {
		joinMeeting.click();

	}

}
