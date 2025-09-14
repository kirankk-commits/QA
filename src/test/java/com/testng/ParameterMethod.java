package com.testng;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseClass.BaseClass;
import com.pageObjectmanager.PageObjectManager;
import com.utility.ExcelReadData;

public class ParameterMethod extends BaseClass{
	@BeforeMethod
	public void beforeMethod() {
		browserLaunch("chrome");
		launchURL(PageObjectManager.getpageObjectManger().getFileReder().getDataProperty("url"));
	}
	@DataProvider(name="LoginData")
	public Object[][] loginData(){
		return new Object[][] {
			{"kiran","qwq"},
			{"asas","aasas"}
		};
	}
	@DataProvider(name="ExcelDataSet")
	public Object[][] dataProviderExcel(){
		String filepath="C:\\Users\\ganug\\eclipse-workspace\\MavenProjectOne\\src\\test\\resources\\DATA.xlsx";
		String sheetName="DATA";
		return ExcelReadData.getExcelData(filepath,sheetName);
	}
	@Test (dataProvider="ExcelDataSet")
	//@Parameters({"username","password"})
	public void login(String User ,String Password) {
		driver.findElement(By.id("user-name")).sendKeys(User);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
	}

}
