package com.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	
	private By accountSections = By.cssSelector("div#center_column span");
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getAccountSectionCount() {
		
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountSectionList() {
		
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSections);
		
		for(WebElement e : accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
	}
	
		return accountsList;

}
}