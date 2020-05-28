package com.appium.test;

import org.testng.annotations.Test;

import com.appium.pageObjects.pageObjects_Mohan;
import com.beust.jcommander.Parameter;
import com.helper.DatabaseConnector;
import com.helper.ExcelUtil;
import com.helper.UserActions;
import com.listner.TestListener;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


//@Listeners(TestListener.class)

public class wordweb_Mohan  {
	

	UserActions user;
	AndroidDriver driver;
	
	static String accessKey = null;
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Entering Suite");
	}

	@Parameters({"Device"})	
	@BeforeTest
	public void setUp(String Device) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		System.out.println(Device);
		if (Device.contentEquals("Real_Device")) {
			System.out.println("Entering locl device");
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformVersion", "10");
			desiredCapabilities.setCapability("udid", "RZ8M90DTVRN");
			desiredCapabilities.setCapability("deviceName", "Samsung");
			desiredCapabilities.setCapability("appPackage", "com.wordwebsoftware.android.wordweb");
			desiredCapabilities.setCapability("appActivity", "com.wordwebsoftware.android.wordweb.activity.WordWebActivity");
			desiredCapabilities.setCapability("unicodeKeyboard", "true");
			desiredCapabilities.setCapability("resetKeyboard", "true");
			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
			
		} else if (Device.contentEquals("Cloud_Device")) {
			System.out.println("Entering Cloud device");
			desiredCapabilities.setCapability("testName", "WordWeb");
			accessKey = "eyJ4cC51Ijo0NTU2OTcsInhwLnAiOjQ1NTY4OSwieHAubSI6Ik1UVTRPVE0yTnprMU1EQXlNdyIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE5MDQ3Mjc5NTAsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.9PEKvslTXNVQjibm_oLIBni8iknsIwo1etQfjBMQ8ME";
			desiredCapabilities.setCapability("accessKey", accessKey);
			desiredCapabilities.setCapability("deviceQuery", "@os='android' and @category='PHONE'");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.wordwebsoftware.android.wordweb");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.wordwebsoftware.android.wordweb.activity.WordWebActivity");
			desiredCapabilities.setCapability("unicodeKeyboard", "true");
			desiredCapabilities.setCapability("resetKeyboard", "true");
			driver = new AndroidDriver(new URL("https://demo.experitest.com/wd/hub"), desiredCapabilities);
			user= new UserActions(driver);
		}else if (Device.contentEquals("Emulator_Device")) {
			System.out.println("Entering Emulator");
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("platformVersion", "9");
			desiredCapabilities.setCapability("udid", "emulator-5554");
			desiredCapabilities.setCapability("deviceName", "Emulator");
			desiredCapabilities.setCapability("appPackage", "com.wordwebsoftware.android.wordweb");
			desiredCapabilities.setCapability("appActivity", "com.wordwebsoftware.android.wordweb.activity.WordWebActivity");
			desiredCapabilities.setCapability("unicodeKeyboard", "true");
			desiredCapabilities.setCapability("resetKeyboard", "true");
			URL remoteUrl = new URL("http://localhost:4723/wd/hub");
			 driver = new AndroidDriver(remoteUrl, desiredCapabilities);
			user= new UserActions(driver);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void loadDatabase() throws IOException {
		if(accessKey==null) {
			user.Click(pageObjects_Mohan.clikCheckatabase);
		}
	}

	@Ignore
	@Test
	public void WordwebWithoutDP() throws IOException {
		user.ClearAndSendKeys(pageObjects_Mohan.searchText, "Hello");
		user.Click(pageObjects_Mohan.clickFirstResult);
		user.pass("Tetxt search result", driver);
		user.Click(pageObjects_Mohan.bookMark);
		user.Click(pageObjects_Mohan.backButton);
		user.Click(pageObjects_Mohan.searchTab);
		switch (Integer.parseInt( "1")) {
		case 1:
			user.Click(pageObjects_Mohan.noun);
			break;
		case 2:
			user.Click(pageObjects_Mohan.verb);
			break;
		case 3:
			user.Click(pageObjects_Mohan.adverb);
			break;
		case 4:
			user.Click(pageObjects_Mohan.adjuctive);
			break;

		default:
			user.Click(pageObjects_Mohan.noun);
		}
		user.ClearAndSendKeys(pageObjects_Mohan.searchText, "1");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		user.Click(pageObjects_Mohan.clickFirstResultType);
		user.pass("Tetxt search result", driver);
		user.Click(pageObjects_Mohan.bookMark);
		user.Click(pageObjects_Mohan.backButton);
		user.Click(pageObjects_Mohan.lookup);
	}

	@Test(dataProvider = "dp")
	public void Wordweb(String searchText, String wordType) throws IOException {
		
		user.ClearAndSendKeys(pageObjects_Mohan.searchText, searchText);
		user.Click(pageObjects_Mohan.clickFirstResult);
		user.pass("Tetxt search result", driver);
		user.Click(pageObjects_Mohan.bookMark);
		user.Click(pageObjects_Mohan.backButton);
		user.Click(pageObjects_Mohan.searchTab);
		System.out.println(wordType);
		
		switch (Integer.parseInt( wordType)) {
		case 1:
			user.Click(pageObjects_Mohan.noun);
			break;
		case 2:
			user.Click(pageObjects_Mohan.verb);
			break;
		case 3:
			user.Click(pageObjects_Mohan.adverb);
			break;
		case 4:
			user.Click(pageObjects_Mohan.adjuctive);
			break;

		default:
			user.Click(pageObjects_Mohan.noun);
		}
		
		user.ClearAndSendKeys(pageObjects_Mohan.searchText, searchText);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		user.Click(pageObjects_Mohan.clickFirstResultType);
		user.pass("Tetxt search result", driver);
		user.Click(pageObjects_Mohan.bookMark);
		user.Click(pageObjects_Mohan.backButton);
		user.Click(pageObjects_Mohan.lookup);

	}
	
	  @DataProvider
	  public Object[][] dp() throws SQLException {
//		  Object data[][]= ExcelUtil.getTestData("./testData.xlsx", "Mohan")  ;
		  Object data[][]= DatabaseConnector.getDataFromDatabase("Mohan");	 
		  

		  return data;
		  }

	@AfterClass
	public void exit() throws IOException {
		user.pass("Exiting Application", driver);
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuit() {
		System.out.println("Exiting Suite");
	}

}
