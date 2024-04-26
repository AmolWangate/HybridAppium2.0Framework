package com.test.driverfactory;

import io.appium.java_client.AppiumDriver;

public final class DriverManager {

	private DriverManager() {

	}

	private static ThreadLocal<AppiumDriver> threadLocalDriver = new ThreadLocal<>();

	static synchronized void setAppiumDriver(AppiumDriver appiumDriver) {
		threadLocalDriver.set(appiumDriver);
	}

	public static synchronized AppiumDriver getAppiumDriver() {
		return threadLocalDriver.get();
	}

	static synchronized void unload() {
		threadLocalDriver.remove();
	}

}
