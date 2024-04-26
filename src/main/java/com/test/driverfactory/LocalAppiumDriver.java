package com.test.driverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.customexceptions.InvalidDriverTypeException;
import com.test.enums.DriverType;

import io.appium.java_client.AppiumDriver;

public class LocalAppiumDriver implements IDriver {

	private static final Logger LOG = LogManager.getLogger();

	@Override
	public AppiumDriver getDriver(DriverType driverType) {
		AppiumDriver driver;
		if (driverType.equals(DriverType.ANDROID)) {
			LOG.info("Launching local android driver");
			driver = new LocalAndroidDriver().getAndroidDriver();
		} else if (driverType.equals(DriverType.IOS)) {
			LOG.info("Launching local ios driver");
			driver = new LocalIOSDriver().getIOSDriver();
		} else {
			LOG.fatal("Invalid driver type value");
			throw new InvalidDriverTypeException(String.format("Provided driver type % is invalid", driverType.name()));
		}

		return driver;
	}

}
