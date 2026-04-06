package org.testng.test.sample;

import org.testng.annotations.Test;

public class Group {

	@Test(groups="smoke")
	private void test1() {
		System.out.println("This is test1");

	}
	@Test(groups="sanity")
	private void test2() {
		System.out.println("This is test2");

	}
	@Test(groups="regression")
	private void test3() {
		System.out.println("This is test3");

	}
	@Test(groups="smoke")
	private void test4() {
		System.out.println("This is test4");

	}
	@Test(groups="sanity")
	private void test5() {
		System.out.println("This is test5");

	}
	@Test(groups="regression")
	private void test6() {
		System.out.println("This is test6");

	}
}
