package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends PageActions {
	

	public LeadPage(WebDriver driver, ExtentTest logger)
	{
		super(driver, logger);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLead;
	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="button12")
	WebElement tb_save;
	
	public void chickNewLead()
	{
		clickElement(lnk_NewLead, "Link Newlead clicked");
	}
	
	public void createlead(String lname, String comp)
	{
		setInput(tb_lastname,lname,lname+" has been entered into lastname field");
		setInput(tb_company,comp,comp+" has been entered into company field");
		clickElement(tb_save, "Save button clicked");
	}

}
