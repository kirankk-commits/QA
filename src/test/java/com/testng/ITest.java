package com.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.baseClass.BaseClass;

public class ITest extends BaseClass{
	WebDriver driver ;
	@BeforeMethod
	private void BeforeTest() {
		browserLaunch("chrome");
		launchURL("https://www.google.com");
		Terminate();
		
	  
	}

}
