package com.testng;

import org.testng.annotations.Test;

import com.baseClass.BaseClass;

public class InvocationCountClass extends BaseClass {
	@Test(invocationCount = 5)
	private void launch() {
		browserLaunch("chrome");
		launchURL("https://www.google.com/");
		Terminate();
	}
	

}
