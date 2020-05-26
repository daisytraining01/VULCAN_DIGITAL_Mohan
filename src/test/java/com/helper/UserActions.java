package com.helper;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.listner.TestListener;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public class UserActions {

	
	public UserActions(AndroidDriver driver){
		
		this.driver = driver;
		
	}

	AndroidDriver driver ;

	public  void pass(String Text) {
		TestListener.test.get().pass(Text);
	}
	
	public  void pass(String Text,AndroidDriver<MobileElement> driver) throws IOException {
		System.out.println(driver !=null);
		if(TestListener.test!=null) {
			TestListener.test.get().pass(Text,MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
		}
		
	}
	
	
	public  void fail(String Text,AndroidDriver<MobileElement> driver) throws IOException {
		System.out.println(driver !=null);
		
		TestListener.test.get().fail(Text,MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
	}
	


	public void Select_By_VisibleText(By locator,String text) {
		Select s=new Select(driver.findElement(locator));
		 s.selectByVisibleText(text);
		
	}

	//=================================================================



	public boolean isDisplayed(By Locator) {
		return driver.findElement(Locator).isDisplayed();
	}

	public boolean isEnabled(By Locator) {
		return driver.findElement(Locator).isEnabled();
	}

	public boolean isSelected(By Locator) {
		return driver.findElement(Locator).isSelected();
	}

	public void Click(By Locator) {
		driver.findElement(Locator).click();
	}

	public void SendKeys(By Locator, String text) {
		driver.findElement(Locator).sendKeys(text);
	}


	public void ClearAndSendKeys(By Locator, String text) {
		driver.findElement(Locator).click();
		driver.findElement(Locator).clear();
		driver.findElement(Locator).sendKeys(text);
	}

	public void WaitAndClick(By Locator, int TimeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
	}

	public void WaitAndSendKeys(By Locator, int TimeOutInSeconds, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		ele.click();
		ele.sendKeys(Text);
	}

	public void WaitClearAndSendKeys(By Locator, int TimeOutInSeconds, String Text) {
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		ele.click();
		ele.clear();
		ele.sendKeys(Text);
	}

	public void Quit() {
		driver.quit();

	}
	
//	MOhan----------------------------
	public void selectFromDropDown(By Locator, String text) {
		Select element = new Select(driver.findElement(Locator));
		element.selectByVisibleText(text);
	}
	
	public void pressBackButton(){
		driver.navigate().back();
	}
//	-------------------------------------------------------


}
