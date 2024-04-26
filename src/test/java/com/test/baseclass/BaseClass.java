package com.test.baseclass;

import org.aeonbits.owner.ConfigFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.test.driverfactory.DriverFactory;
import com.test.enums.DriverType;
import com.test.enums.Mode;
import com.test.exectuion.result.update.UpdateStatus;
import com.test.ownerinterfaces.IEnvConfigProp;

public class BaseClass {

	@BeforeMethod
	public void setUp() {
		IEnvConfigProp prop = ConfigFactory.create(IEnvConfigProp.class);
		DriverFactory.initDriver(Mode.valueOf(prop.mode().toUpperCase()),
				DriverType.valueOf(prop.drivertype().toUpperCase()));
	}

	@AfterMethod
	public void tearDown(ITestResult iTestResult) {
		DriverFactory.quitDriver();
		UpdateStatus.updateExectionStatus(Mode.valueOf(ConfigFactory.create(IEnvConfigProp.class).mode().toUpperCase()), iTestResult);
	}

}
