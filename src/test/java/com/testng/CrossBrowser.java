package com.testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.baseClass.BaseClass;

public class CrossBrowser extends BaseClass{
	@Ignore
	private void fireFox() {
		browserLaunch("firfox");
		launchURL("https://www.facebook.com/");
		System.out.println("Browser ID:"+ Thread.currentThread().getId());
		
	}
	@Test
	private void chrome() {
		browserLaunch("chrome");
		launchURL("https://www.facebook.com/");
		System.out.println("Browser ID:"+ Thread.currentThread().getId());
		
	}
	@Test
	private void edge() {
		browserLaunch("edge");
		launchURL("https://www.facebook.com/");
		System.out.println("Browser ID:"+ Thread.currentThread().getId());
		
	}
	

}
