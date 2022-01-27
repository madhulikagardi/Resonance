package com.opencard.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class PropertiesUtil {
	
	public String getValue(String filepath,String key) {

		FileInputStream file = null ; 
		try {
			file=new FileInputStream(filepath);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			
		}
		Properties prop = new Properties();
		String value=null;
		try {
			prop.load(file);
			value=prop.getProperty(key);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return value;
		
	}
	
		public String [] getLocator(String key) {
			String dir=System.getProperty("user.dir");
			String locator=getValue(dir+"/src/main/resources/OR.properties", key);
			String parts[]=locator.split("##");
			return parts;
		}

}
