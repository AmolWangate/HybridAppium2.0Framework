package com.test.driverfactory;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;

import com.test.customexceptions.SessionNotCreatedException;

import io.appium.java_client.android.AndroidDriver;

public class SauceLabsAndroidDriver {
	
	public AndroidDriver getAndroidDriver() {
		AndroidDriver driver = null;
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:deviceName", "Samsung.*");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:app", "storage:filename=androiddemo.apk");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "latest");
		sauceOptions.setCapability("username", "demoSauceUser");
		sauceOptions.setCapability("accessKey", "fa153bc3-18f3-4402-b93d-61f2751b56e3");
		caps.setCapability("sauce:options", sauceOptions);
		try {
			driver = new AndroidDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
		} catch (Exception e) {
			throw new SessionNotCreatedException(e.getMessage(), e.getCause());
		}
		return driver;

	}
}
