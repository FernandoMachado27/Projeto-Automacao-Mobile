package br.com.fernando.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

		MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("2");
		el6.click();
		MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("plus");
		el7.click();
		MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("2");
		el8.click();
		MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("equals");
		el9.click();
		MobileElement el2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
		el2.click();
		
		System.out.println(el2.getText());

		Assert.assertEquals("5", el2.getText());
		driver.quit();
	}

}
