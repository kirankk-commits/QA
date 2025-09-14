package com.testng;

import org.testng.annotations.Test;

public class GroupingClass {
	@Test(groups= "movies")
	private void leo() {
		System.out.println("LEO");
	}
	@Test(groups= "movies")
	private void jailer() {
		System.out.println("JAILER");
	}
	@Test(groups= "movies")
	private void RRR() {
		System.out.println("RRR");
	}
	@Test(groups= "language")
	private void tamil() {
		System.out.println("TAMIL");
	}
	@Test(groups= "language")
	private void telugu() {
		System.out.println("TELUGU");
	}
	@Test(groups= "language")
	private void english() {
		System.out.println("ENGLISH");
	}
	@Test(groups= "actors")
	private void vijay() {
		System.out.println("VIJAY");
	}
	@Test(groups= "actors")
	private void ajith() {
		System.out.println("AJITH");
	}
	@Test(groups= "actors")
	private void kiran() {
		System.out.println("Kiran");
	}
	

}
