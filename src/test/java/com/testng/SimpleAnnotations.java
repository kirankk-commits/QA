package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SimpleAnnotations{
	
	@BeforeSuite
	private void propertySetting () {
		System.out.println("prperty setting");
		
	}
	@BeforeTest
	private void browserLaunch() {
		System.out.println("Browser launch");
		
	}
	@BeforeClass
	private void urlLaunch() {
		System.out.println("url launched");
	}
	@BeforeMethod
	private void login() {
		System.out.println("login");
	}
	@Test (priority=-1)
	private void search() {
		System.out.println("search product");
		
	}
	@Test(priority= 0)
	private void addToCart() {
		System.out.println("add to cart");
		
	}
	@Test(priority= 1,dependsOnMethods= {"search","addToCart"})
	private void payment() {
		System.out.println("payment section");
		
	}
	@AfterMethod
	private void logout() {
		System.out.println("logout");
	}
	@AfterClass
	private void screenshot() {
		System.out.println("screenshot");
	}
	@AfterTest
	private void close() {
		System.out.println("close");
	}
	@AfterSuite
	private void termination() {
		System.out.println("Termination");
		
	}
	
	
	
	
}