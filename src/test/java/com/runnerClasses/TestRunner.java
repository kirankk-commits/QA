package com.runnerClasses;


import org.openqa.selenium.By;

import com.baseClass.BaseClass;
import com.pageObjectmanager.PageObjectManager;
import com.utility.ExcelReadData;

public class TestRunner extends BaseClass{
	
	public static void main(String[] args) {
		browserLaunch("chrome");
		/*browserLaunch(PageObjectManager.getpageObjectManger().getFileReder().getDataProperty("browser"));*/
		launchURL(PageObjectManager.getpageObjectManger().getFileReder().getDataProperty("url"));
		String username = ExcelReadData.readParticularData(0,0);
		driver.findElement(By.id("user-name")).sendKeys(username);
		String pass = ExcelReadData.readParticularData(1,0);
		driver.findElement(By.id("password")).sendKeys(pass);
		//elementClick(PageObjectManager.getpageObjectManger().getLoginPage().loginPage());
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		handleAlert("accept");
		
		
		
	   

	}

}
