package com.test.driverfactory;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;

import com.test.customexceptions.SessionNotCreatedException;

import io.appium.java_client.ios.IOSDriver;

public class SauceLabsIOSDriver {

	public IOSDriver getIOSDriver() {
		IOSDriver driver = null;
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("appium:app", "storage:filename=SauceLabs-Demo-App-With-TestFairy.ipa");
		caps.setCapability("appium:deviceName", "iPhone.*");
		caps.setCapability("appium:automationName", "XCUITest");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "latest");
		sauceOptions.setCapability("username", "demoSauceUser");
		sauceOptions.setCapability("accessKey", "fa153bc3-18f3-4402-b93d-61f2751b56e3");
		caps.setCapability("sauce:options", sauceOptions);
		try {
			driver = new IOSDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
		} catch (Exception e) {
			throw new SessionNotCreatedException(e.getMessage(), e.getCause());
		}

		return driver;
	}
}
