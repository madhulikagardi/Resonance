package com.Baseframework;

import com.opencard.utility.PropertiesUtil;

public class Config {
	
	public String getAppUrl(){
		return getProperty("app.url");
	}
	
	public String getBrowserName() {
		return getProperty("browser_name");
	}
	
	private String getProperty(String property) {
		PropertiesUtil proputil = new PropertiesUtil();
		String dir=System.getProperty("user.dir");
		return proputil.getValue(dir+"/src/main/resources/application.properties", property);
		
	}

}
