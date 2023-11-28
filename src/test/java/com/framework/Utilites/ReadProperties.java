package com.framework.Utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	private static Properties properties = new Properties();

	static {
		try {
			FileInputStream inputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\Propertiesfile\\config.properties");
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
}
