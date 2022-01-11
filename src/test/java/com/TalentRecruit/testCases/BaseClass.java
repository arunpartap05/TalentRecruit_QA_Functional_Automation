package com.TalentRecruit.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.TalentRecruit.utilities.ReadConfig;

public class BaseClass

{
	/*
	 * public String baseURL="https://stg.talentmarx.in/auth/login"; public String
	 * email="arunpartap05@gmail.com"; public String password="Aps@0001";
	 */
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String email = readconfig.getUserEmail();
	public String password = readconfig.getUserPassword();
	public static String browSize;
	// private Logger bsize;
	public static WebDriver driver;
	public static Logger logger;
	public static String timeStamp1 = null;

	enum browserSize {
		small, medium, large;
	}

	@Parameters({ "browser", "browsersize" })
	@BeforeClass
	public void setup(String br, String brSize)

	{
		browSize = brSize;

		logger = Logger.getLogger("TalentRecruit");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equalsIgnoreCase("chrome"))

		{

			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			options.addArguments("incognito");
			driver = new ChromeDriver(cap);

			// added to resize the screen
			if (brSize.equalsIgnoreCase("large")) {

				Dimension dimension = new Dimension(1366, 768);
				driver.manage().window().setSize(dimension);

			}

			else if (brSize.equalsIgnoreCase("medium"))

			{

				Dimension dimension = new Dimension(960, 540);
				driver.manage().window().setSize(dimension);

			}

			else if (brSize.equalsIgnoreCase("small"))

			{
				Dimension dimension = new Dimension(320, 569);
				driver.manage().window().setSize(dimension);

			}

		}

		else if (br.equalsIgnoreCase("firefox"))

		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}

		else if (br.equalsIgnoreCase("IE"))

		{
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();

		}

		else if (br.equalsIgnoreCase("edge"))

		{
			System.setProperty("webdriver.edge.driver", readconfig.getedgepath());
			driver = new EdgeDriver();
		}

		driver.get(baseURL);
		logger.info("URL Launced");

	}

	@AfterClass
	public void teardown()

	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException

	{
		timeStamp1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trt = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + timeStamp1 + ".png");
		FileUtils.copyFile(src, trt);
		System.out.println("Screenshot Taken");
	}

}
