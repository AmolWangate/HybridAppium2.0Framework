package com.test.driverfactory;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.test.customexceptions.SessionNotCreatedException;

import io.appium.java_client.android.AndroidDriver;

public class BrowserStackAndroidDriver {

	public AndroidDriver getAndroidDriver() {
		AndroidDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<>();
		browserstackOptions.put("appiumVersion", "2.4.1");
		browserstackOptions.put("idleTimeout", "120");
		browserstackOptions.put("debug", "true");
		browserstackOptions.put("userName", "jondoe_8YE7Zw");
		browserstackOptions.put("accessKey", "KeaL44J9iGZvHyKXXK9h");
		capabilities.setCapability("bstack:options", browserstackOptions);
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("deviceName", "Samsung.*");
		capabilities.setCapability("app", "bs://5e26da7b3cf6a9a800bcb007f1176d3375fc74fa");
		try {
			driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub/"), capabilities);
		} catch (Exception e) {
			throw new SessionNotCreatedException(e.getMessage(), e.getCause());
		}

		return driver;

	}

}
