package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//1.By Locators
	
	private By emailID = By.id("email");
	private By passWord = By.id("passwd");
	private By signButton = By.id("SubmitLogin");
	private By forgotPswLink = By.linkText("Forgot your password?");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//2.Page Actions
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean isForgotPwdLinkExist()
	{
		return driver.findElement(forgotPswLink).isDisplayed();
	}
	public void enterUserName(String username)
	{
		driver.findElement(emailID).sendKeys(username);
	}
	public void enterPwd(String pwd)
	{
		driver.findElement(passWord).sendKeys(pwd);
	}
	public void clickSignButton()
	{
		driver.findElement(signButton).click();
	}
	public AccountPage doLogin(String un,String pwd) {
		System.out.println("Login with: " + un  + "and" + pwd);
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(passWord).sendKeys(pwd);
		driver.findElement(signButton).click();
		return new AccountPage(driver);
	}
}
