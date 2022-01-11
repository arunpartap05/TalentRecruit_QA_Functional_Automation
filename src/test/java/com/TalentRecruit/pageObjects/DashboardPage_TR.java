package com.TalentRecruit.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage_TR

{

	WebDriver ldriver;

	public DashboardPage_TR(WebDriver rdriver)

	{

		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath = "//a[@class='mat-menu-trigger user-dropdown']")
	@CacheLookup
	WebElement drpDown;

	@FindBy(xpath = "//span[@class='icon-mc mc-menu header-icon']")
	@CacheLookup
	WebElement drpDown_s;

	@FindBy(xpath = "//button[@role='menuitem']//span[contains(text(),'Signout')]")
	@CacheLookup
	public WebElement signOut;

	@FindBy(xpath = "//span[normalize-space()='Signout']")
	@CacheLookup
	public WebElement signOut_s;

	public void clickDropdown()

	{
		drpDown.click();
	}

	public void clickDropdown_s()

	{
		drpDown_s.click();
	}

	public void clickSignOut()

	{
		signOut.click();
	}

	public void clickSignOut_s()

	{
		signOut_s.click();
	}

}
