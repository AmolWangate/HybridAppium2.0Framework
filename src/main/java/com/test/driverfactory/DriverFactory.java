package com.test.driverfactory;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.customexceptions.InvalidModeException;
import com.test.enums.DriverType;
import com.test.enums.Mode;

public final class DriverFactory {
	
	
	private static final Logger LOG=LogManager.getLogger();

	private DriverFactory() {

	}

	public static void initDriver(Mode mode, DriverType driverType) {
		if (Objects.isNull(DriverManager.getAppiumDriver())) {
			if (mode.equals(Mode.LOCAL)) {
				LOG.info("launching local driver");
				DriverManager.setAppiumDriver(new LocalAppiumDriver().getDriver(driverType));
			} else if (mode.equals(Mode.BROWSERSTACK)) {
				LOG.info("launching remote browserstack driver");
				DriverManager.setAppiumDriver(new RemoteBrowserStackDriver().getDriver(driverType));
			} else if (mode.equals(Mode.SAUCELABS)) {
				LOG.info("launching remote sauce labs driver");
				DriverManager.setAppiumDriver(new RemoteSauceLabsDriver().getDriver(driverType));
			} else {
				LOG.fatal("Invalid mode value");
				throw new InvalidModeException(String.format("Provided mode %s is invalid", mode.name()));
			}
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getAppiumDriver())) {
			LOG.info("quitting driver");
			DriverManager.getAppiumDriver().quit();
			DriverManager.unload();
		}
	}

}
