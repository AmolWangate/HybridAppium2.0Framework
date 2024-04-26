package com.test.driverfactory;

import com.test.enums.DriverType;

import io.appium.java_client.AppiumDriver;

public interface IDriver {

	AppiumDriver getDriver(DriverType driverType);

}
