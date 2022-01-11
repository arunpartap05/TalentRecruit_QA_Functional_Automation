package com.TalentRecruit.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPageTR 

{
  
	WebDriver ldriver;
	  
	public PasswordPageTR(WebDriver rdriver)
	   
	 {
		   
		 ldriver=rdriver;
		 PageFactory.initElements(ldriver, this);
		    	
	 }
	
	   @FindBy(xpath="//input[@type='password']")
	   @CacheLookup
	   WebElement txtPasswd; 
	   
	   @FindBy(xpath="//span[contains(text(),'Sign In')]")
	   @CacheLookup
	   WebElement bttnSignIn; 
	   
	   @FindBy(xpath="//a[normalize-space()='Sign Up']")
	   @CacheLookup
	   WebElement lnkSignUp;
	   
	   @FindBy(xpath="//a[normalize-space()='Forgot Password ?']")
	   @CacheLookup
	   WebElement lnkForgetPasswd;
	  
	   @FindBy(xpath="//a[normalize-space()='Account']")
	   @CacheLookup
	   WebElement lnkAccount;
	   
	   public void setPassword (String upassword)
	   
	   {
		   txtPasswd.sendKeys(upassword);
	   }
	   
	   public void clkbttnSignIn ()
	   
	   {
		  bttnSignIn.click();
	   }
	   
	   public void clklnkSignUp ()

	   
	   {
		   lnkSignUp.click();
	   }
	   
	   public void clklnkFgtPassword ()
	   
	   {
		   lnkSignUp.click();
	   }
	   
	   public void clklnkAccount ()
	   
	   {
		   lnkAccount.click();	   
		   
	   }
	   
	   
}
