package com.test.extentreports;

import org.aeonbits.owner.ConfigFactory;

import com.test.ownerinterfaces.IEnvConfigProp;

public final class ExtentLogger {

	private static IEnvConfigProp prop = ConfigFactory.create(IEnvConfigProp.class);

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void pass(String message, boolean isTrue) {
		if (prop.passscreenshot() && isTrue) {
			ExtentManager.getExtentTest().pass(message, CaptureScreenshot.getBase64Screenshot());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isTrue) {
		if (prop.failscreenshot() && isTrue) {
			ExtentManager.getExtentTest().fail(message, CaptureScreenshot.getBase64Screenshot());
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isTrue) {
		if (prop.skipscreenshot() && isTrue) {
			ExtentManager.getExtentTest().skip(message, CaptureScreenshot.getBase64Screenshot());
		} else {
			skip(message);
		}
	}

	public static void info(String message, boolean isTrue) {
		if (prop.infoscreenshot() && isTrue) {
			ExtentManager.getExtentTest().info(message, CaptureScreenshot.getBase64Screenshot());
		} else {
			info(message);
		}
	}
}
