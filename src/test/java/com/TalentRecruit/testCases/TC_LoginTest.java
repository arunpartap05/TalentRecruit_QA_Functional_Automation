package com.TalentRecruit.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.TalentRecruit.pageObjects.LoginPageTR;
import com.TalentRecruit.pageObjects.PasswordPageTR;

public class TC_LoginTest extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException, IOException
	
	{
		
		//driver.get(baseURL);
		//logger.info("URL Launced");
		LoginPageTR lgnpage = new LoginPageTR (driver);
		lgnpage.setEmail(email);
		logger.info("Email Entered");
		lgnpage.clkbttnNext();
		logger.info("Next button clicked");
		Thread.sleep(10000);
		PasswordPageTR pwdpage = new PasswordPageTR (driver);
		pwdpage.setPassword(password);
		logger.info("Password Entered");
		pwdpage.clkbttnSignIn();
		logger.info("Sign In button clicked");
		Thread.sleep(50000);
        captureScreen(driver, "logintest");
		System.out.println("Logged in succcessfully");
			
	}
	
	

}