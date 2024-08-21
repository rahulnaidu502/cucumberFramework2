package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageActions {


	public HomePage(WebDriver driver, ExtentTest logger)
	{
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
	
//	private String uid = "user_name";
//	By uid = By.name("user_name");
	
	@FindBy(linkText="Logout")
	WebElement lnk_logout;
	
	@FindBy(linkText="Home")
	WebElement lnk_home;
	
	public void click_logout()
	{
		clickElement(lnk_logout, "Link Logout clicked");
	}
	
	public void validate_logout()
	{
		isElementExist(lnk_logout, "Link Logout is displayed");
	}

	public void validate_home()
	{
		isElementExist(lnk_home, "Link Home is displayed");
	}
	
	
}
