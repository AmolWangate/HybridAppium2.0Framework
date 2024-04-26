package com.test.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.aeonbits.owner.ConfigFactory;

import com.test.constants.FrameworkConstants;
import com.test.ownerinterfaces.IEnvConfigProp;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;

public class LocalIOSDriver {

	public IOSDriver getIOSDriver() {
		IOSDriver driver = null;
		XCUITestOptions options = new XCUITestOptions();
		options.setPlatformName("ios");
		options.setAutomationName(AutomationName.IOS_XCUI_TEST);
		options.setUdid("emulator-5554");
		options.setApp(FrameworkConstants.getIpaEmulatorFilePath());
		try {
			driver = new IOSDriver(new URL(ConfigFactory.create(IEnvConfigProp.class).url()), options);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;

	}

}
