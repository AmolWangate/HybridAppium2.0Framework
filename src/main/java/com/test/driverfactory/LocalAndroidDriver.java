package com.test.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.aeonbits.owner.ConfigFactory;

import com.test.constants.FrameworkConstants;
import com.test.ownerinterfaces.IEnvConfigProp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class LocalAndroidDriver {

	public AndroidDriver getAndroidDriver() {
		AndroidDriver appiumDriver = null;
		UiAutomator2Options automator2Options = new UiAutomator2Options();
		automator2Options.setPlatformName("Android");
		automator2Options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		automator2Options.setUdid("emulator-5554");
		automator2Options.setApp(FrameworkConstants.getApkFilePath());
		try {
			appiumDriver = new AndroidDriver(new URL(ConfigFactory.create(IEnvConfigProp.class).url()),
					automator2Options);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		}
		return appiumDriver;

	}

}
