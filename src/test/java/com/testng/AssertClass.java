package com.testng;

import org.junit.Assert;
import org.testng.annotations.Test;

public class AssertClass {
	@Test
	private void name() {
		String actual="kiran";
		String expected="Kiran";
		Assert.assertEquals(actual, expected);
		System.out.println("validation done");
	}
	
	

}
