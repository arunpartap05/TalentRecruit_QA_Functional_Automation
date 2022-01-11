package com.TalentRecruit.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTR

{

	WebDriver ldriver;

	public LoginPageTR(WebDriver rdriver)

	{

		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	@CacheLookup
	WebElement bttnNext;

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	@CacheLookup
	WebElement lnkSignUp;

	@FindBy(xpath = "//a[normalize-space()='Terms and Conditions']")
	@CacheLookup
	WebElement lnkTermnCondt;

	@FindBy(xpath = "//mat-error[contains(text(),'Email does not exist')]")
	@CacheLookup
	public WebElement invalidEmail;

	public void setEmail(String uemail)

	{
		txtEmail.clear();
		txtEmail.sendKeys(uemail);
	}

	public void clkbttnNext()

	{
		bttnNext.click();
	}

	public void clklnkSignUp()

	{
		lnkSignUp.click();
	}

	public void clklnkTermnCondt()

	{
		lnkTermnCondt.click();
	}

}
