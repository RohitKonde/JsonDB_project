package com.SwagLab.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static Properties p1;

	public PropertiesFile() {
		File f1 = new File(System.getProperty("user.dir") + "\\config\\config.properties");
		p1 = new Properties();
		try {
			FileInputStream fs = new FileInputStream(f1);
			p1.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return p1;
	}

	public static String getProp(String prop) {
		return p1.getProperty(prop);
	}

}
