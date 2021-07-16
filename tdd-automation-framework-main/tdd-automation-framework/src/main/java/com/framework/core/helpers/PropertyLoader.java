package com.framework.core.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader {

	public static Properties _prop;

	public void loadPropertyFile(String envName) throws Exception {
		File propertyFile = new File(System.getProperty("user.dir")
				+ "//src//test//resources//configs//" + envName + ".properties");
		_prop = new Properties();
		_prop.load(new FileInputStream(propertyFile));

	}

	public String fetchProperty(String propertyName) throws Exception {
		// load property file (sit.properties)
		loadPropertyFile(System.getProperty("envName"));
		String value = _prop.getProperty(propertyName);// getproperty(propName);
		return value;
	}

}
