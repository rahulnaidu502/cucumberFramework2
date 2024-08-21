package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageActions {
	
	// private WebDriver driver;
	
	public LoginPage(WebDriver driver, ExtentTest logger)
	{
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
	
//	private String uid = "user_name";
//	By uid = By.name("user_name");
	
	@FindBy(name="user_name")
	WebElement tb_uid;
	
	@FindBy(name="user_password")
	WebElement tb_password;
	
	@FindBy(xpath="//select[@name='login_theme']")
	WebElement ln_theme;
	
	@FindBy(name="Login")
	WebElement bt_login;
	
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password')]")
	WebElement err_msg;
	

	public void validate_Error_message()
	{
		err_msg.isDisplayed();
	}
	
	public void login(String userid, String pwd)
	{
		setInput(tb_uid,userid,userid+" has been entered into username field");
		setInput(tb_password, pwd,pwd+" has been entered into password field");
		clickElement(bt_login, "Login button clicked");
	}
	
	public void login(String userid, String pwd, String them)
	{
		setInput(tb_uid,userid,userid+" has been entered into username field");
		setInput(tb_password,pwd,pwd+" has been entered into password field");
		setInput(ln_theme,them,them+"has been selected from the dropdown");
		clickElement(bt_login,"Login button clicked");
	}
}
