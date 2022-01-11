package com.TalentRecruit.testCases;

//import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.TalentRecruit.pageObjects.DashboardPage_TR;
import com.TalentRecruit.pageObjects.LoginPageTR;
import com.TalentRecruit.pageObjects.PasswordPageTR;
import com.TalentRecruit.utilities.XlsUtility;

public class TC_LoginTest_Multiple_DataSet extends BaseClass

{ // @Parameters("browsersize")
	@Test(dataProvider = "LoginData")

	public void loginTestMultipleSet(String uemail, String upassword) throws InterruptedException, IOException

	{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPageTR lgnpage = new LoginPageTR(driver);
		lgnpage.setEmail(uemail);
		logger.info("Email Entered");
		lgnpage.clkbttnNext();
		logger.info("Next button clicked");
		// Thread.sleep(30000);
		// if (driver.getPageSource().contains("Email does not exist"))

		if (driver.findElements(By.xpath("//mat-error[@aria-atomic='true']")).size() <= 0)

		{

			System.out.println("in side IF block");
			PasswordPageTR pwdpage = new PasswordPageTR(driver);
			pwdpage.setPassword(upassword);
			logger.info("Password Entered");
			pwdpage.clkbttnSignIn();
			logger.info("Sign In button clicked");
			Thread.sleep(30000);
			DashboardPage_TR dashpage = new DashboardPage_TR(driver);
			
			/*if (browSize.equalsIgnoreCase("small"))
				
			{
			   driver.findElement(By.xpath("dashpage.signOut_s"));
			}
			
			else
			
			{
				
				driver.findElement(By.xpath("dashpage.signOut"));
			}*/
			
			String act = driver.getCurrentUrl();
			
			if (act.equals("https://stg.talentmarx.in/dashboard"))

			{
				Assert.assertTrue(true);
				logger.info("User Logged in with valid credentials");

				if (browSize.equalsIgnoreCase("large"))

				{
					System.out.println("in large size block");
					//DashboardPage_TR dashpage = new DashboardPage_TR(driver);
					dashpage.clickDropdown();
					dashpage.clickSignOut();

				}

				else if (browSize.equalsIgnoreCase("small"))

				{
					System.out.println("in small block");
				//	DashboardPage_TR dashpage = new DashboardPage_TR(driver);
					dashpage.clickDropdown_s();
					dashpage.clickSignOut_s();
				}

				else if (browSize.equalsIgnoreCase("medium"))

				{
					System.out.println("in medium block");
				//	DashboardPage_TR dashpage = new DashboardPage_TR(driver);
					dashpage.clickDropdown();
					dashpage.clickSignOut();
				}

				driver.findElement(By.xpath("//a[normalize-space()='Account']")).click();

			}

			else

			{
				captureScreen(driver, "loginTestMultipleSet");
				driver.findElement(By.xpath("//a[normalize-space()='Account']")).click();
				logger.info("Login Failed:Invalid Password");
				Assert.assertTrue(false);

			}

		}

		else

		{
			System.out.println("Email not Exits");
			logger.info("Email does not Exits.");
			captureScreen(driver, "loginTestMultipleSet");
			Assert.assertTrue(false);

		}

	}

	@DataProvider(name = "LoginData")

	String[][] getData() throws IOException

	{

		String path = System.getProperty("user.dir") + "/src/test/java/com/TalentRecruit/testData/TR_USERIDS.xlsx";
		int rownum = XlsUtility.getRowCount(path, "Sheet1");
		int colnum = XlsUtility.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rownum][colnum];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colnum; j++)

			{
				loginData[i - 1][j] = XlsUtility.getCellData(path, "Sheet1", i, j);
			}

		}
		return loginData;

	}

}
