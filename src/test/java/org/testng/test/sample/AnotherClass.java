package org.testng.test.sample;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AnotherClass {
	
	@Parameters({"username", "password"})
@Test
private void test1(String user,String pass) {
	System.out.println("Test1 from another class");
	System.out.println(user);
	System.out.println(pass);
}

@Test(enabled = false)
private void test2() {

	System.out.println("Test2 from another class");
}
@Parameters({"Username"})
@Test
private void test3(@Optional("Fatin")String user1) {
	System.out.println("Test3 from another class");
	System.out.println(user1);

}
}
