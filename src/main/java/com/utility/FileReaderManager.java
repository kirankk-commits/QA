package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	private static FileInputStream fileInputStream;
	private static Properties property;
	
	private static void setupProperty()  {
		File file = new File("C:\\Users\\ganug\\eclipse-workspace\\MavenProjectOne\\src\\main\\resources\\TestData.properties");
		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
			
		} catch (FileNotFoundException e) {
			Assert.fail("ERROR:OCCUR FILE NOT FOUND EXCEPTION");		
		}catch (IOException e) {
			Assert.fail("ERROR: OCCUR DURNG THE FILE READ");
		}
		
		
	}
	public static String getDataProperty(String Key) {
		setupProperty();
		String value = property.getProperty(Key);
		return value;
		
	}
	public static void main (String[] args) {
		System.out.println(getDataProperty("browser"));
		
	}
}