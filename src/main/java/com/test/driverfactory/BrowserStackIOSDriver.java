package com.test.driverfactory;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.test.customexceptions.SessionNotCreatedException;

import io.appium.java_client.ios.IOSDriver;

public class BrowserStackIOSDriver {

	public IOSDriver getIOSDriver() {
		IOSDriver driver = null;
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<>();
		browserstackOptions.put("appiumVersion", "2.4.1");
		browserstackOptions.put("idleTimeout", "120");
		browserstackOptions.put("debug", "true");
		browserstackOptions.put("userName", "jondoe_8YE7Zw");
		browserstackOptions.put("accessKey", "KeaL44J9iGZvHyKXXK9h");
		capabilities.setCapability("bstack:options", browserstackOptions);
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("deviceName", "iPhone.*");
		capabilities.setCapability("app", "bs://082638ae6f6592017113688352f9c2b21ab59bf0");
		try {
			driver = new IOSDriver(new URL("http://hub.browserstack.com/wd/hub/"), capabilities);
		} catch (Exception e) {
			throw new SessionNotCreatedException(e.getMessage(), e.getCause());
		}
		return driver;

	}
}
