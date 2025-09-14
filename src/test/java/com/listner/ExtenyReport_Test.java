package com.listner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.baseClass.BaseClass;

public class ExtenyReport_Test {
	public static ExtentTest extenttest;

	@BeforeSuite
	public void extentTestReportStartup() throws IOException {
	    BaseClass base = new BaseClass() {
	    };
	    base.extentReportStart(null);
	}

	@AfterSuite
	public void extentReportEnd() throws IOException {
	    BaseClass base = new BaseClass() {
	    };
	    base.extentReportTearDown(null);
	}

}
