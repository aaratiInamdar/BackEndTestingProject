package com.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream fos=new FileInputStream("./ConfigData/CommonData.properties");
		Properties p=new Properties();
		p.load(fos);
		String data = p.getProperty(key);
		return data;
	}
}
