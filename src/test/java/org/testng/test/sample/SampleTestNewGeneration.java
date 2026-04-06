package org.testng.test.sample;

import java.util.Date;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class SampleTestNewGeneration extends BaseClass {
@BeforeClass
private void beforeClass() {
	System.out.println("Before Class");
	chromeBrowser();
	max();
}
@AfterClass()
private void afterClass() {
	System.out.println("After Class");
	close();
}
@BeforeMethod
private void before() {
	Date d =new Date();
	System.out.println("Before Method"+d);

}
@AfterMethod
private void after() {
	Date d=new Date();
	System.out.println("After Method"+d);

}
@Test(priority=1)
private void test1() {
	urlInput("https://www.flipkart.com/");
	String url1 = url();
	boolean c = url1.contains("facebook");
	SoftAssert s=new SoftAssert();
	s.assertTrue(c,"Verify URL");
	LoginPage l=new LoginPage();
	timee(3000);
	l.getPopClose().click();
	sendKey(l.getSearch(), "iphone");
	String search = getAttributeVal(l.getSearch());
	s.assertEquals(search, "iphone", "Search Keyword is ");
	l.getSearchButton().click();
	l.getLogin().click();
	sendKey(l.getEmail(), "fatin@gmail.com");
	String email = getAttributeVal(l.getEmail());
	s.assertEquals(email, "fatin@gmail.com", "Email provided is ");
	l.getBtn().click();
	s.assertAll();
	System.out.println("Test1");

}

@Test(priority=1)
private void test2() {
	System.out.println("Test2");
}
@Test(invocationCount= 2, enabled=false)
private void test3() {
	System.out.println("Test3");

}
}
