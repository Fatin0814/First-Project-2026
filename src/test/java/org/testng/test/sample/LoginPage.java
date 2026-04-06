package org.testng.test.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Login']")
	private WebElement login;
	
	@FindBy(xpath="(//input[@name='q'])[1]")
	private WebElement search;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchButton;
	@FindBy(xpath="//span[@class='b3wTlE']")
	private WebElement popClose;
	
	public WebElement getPopClose() {
		return popClose;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	@FindBy(xpath="//span[@class='v1zwn27']")
	private WebElement loginbtn;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement email;
	
	@FindBy(xpath="//button[text()='Request OTP']")
	private WebElement btn;

	public WebElement getLogin() {
		return login;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getBtn() {
		return btn;
	}
}
