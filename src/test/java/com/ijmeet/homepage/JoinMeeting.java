package com.ijmeet.homepage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Baseframework.BaseFrameWork;
import com.ijmeet.POM.JoinMeetingHomepage;

public class JoinMeeting extends BaseFrameWork {

	@Test
	public void verifyOnClickOnJoinMeetingUserLandsOnQuickJoinMeeting() {
		JoinMeetingHomepage join = PageFactory.initElements(driver, JoinMeetingHomepage.class);
		join.clickOnjoinMeeting();

	}
}

