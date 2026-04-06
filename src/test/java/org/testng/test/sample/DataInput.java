package org.testng.test.sample;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataInput {
	
	@Test(dataProvider="login")
	private void test1(String user,String pass) {
		System.out.println("This is test1");
		System.out.println(user);
		System.out.println(pass);
	}
	
	private void test2() {
		System.out.println("This is test2");

	}
	private void test3() {
		System.out.println("This is test3");

	}
	@DataProvider(name="login")
	private Object data() {
		Object obj[][]=new Object[][] {{"fatin","12345"},{"Jejo","23456"},{"Haydan","34567"}};
		return obj;

	}

}
