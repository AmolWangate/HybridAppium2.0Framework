package com.test.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import com.google.common.collect.ImmutableMap;
import com.test.driverfactory.DriverManager;
import com.test.enums.Scroll;
import com.test.enums.Swipe;
import com.test.enums.WaitType;
import com.test.extentreports.ExtentLogger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public final class DriverUtilities {

	private DriverUtilities() {

	}

	public static void click(WebElement element, WaitType type, String elementName) {
		ExplicitWaitUtility.performExplicitWait(element, type).click();
		ExtentLogger.info(elementName + " is clicked", true);
	}

	public static void sendKeys(WebElement element, WaitType type, String textToBeEntered, String elementName) {
		WebElement inputElement = ExplicitWaitUtility.performExplicitWait(element, type);
		inputElement.clear();
		inputElement.sendKeys(textToBeEntered);
		ExtentLogger.info("Entered " + textToBeEntered + " in " + elementName, true);
	}

	public static String getText(WebElement element, WaitType type, String elementName) {
		String text = ExplicitWaitUtility.performExplicitWait(element, type).getText();
		ExtentLogger.info(elementName + " text value is: " + text, true);
		return text;
	}

	public static void tap(WebElement element, WaitType type, String elementName) {
		RemoteWebElement remoteWebElement = (RemoteWebElement) ExplicitWaitUtility.performExplicitWait(element, type);
		if (DriverManager.getAppiumDriver() instanceof AndroidDriver) {
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: clickGesture",
					ImmutableMap.of("elementId", remoteWebElement.getId()));
		} else {
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: tap",
					ImmutableMap.of("x", 1.0, "y", 1.0, "elementId", remoteWebElement.getId()));
		}
		ExtentLogger.info(elementName + " is tapped", true);
	}

	public static void doubleTap(WebElement element, WaitType type, String elementName) {
		RemoteWebElement remoteWebElement = (RemoteWebElement) ExplicitWaitUtility.performExplicitWait(element, type);
		((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", remoteWebElement.getId()));
		ExtentLogger.info(elementName + " is double tapped", true);
	}

	public static void longPress(WebElement element, WaitType type, String elementName) {
		RemoteWebElement remoteWebElement = (RemoteWebElement) ExplicitWaitUtility.performExplicitWait(element, type);
		if (DriverManager.getAppiumDriver() instanceof AndroidDriver) {
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: longClickGesture",
					ImmutableMap.of("duration", 5, "elementId", remoteWebElement.getId()));
		} else {
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: touchAndHold",
					ImmutableMap.of("duration", 5, "elementId", remoteWebElement.getId()));
		}
		ExtentLogger.info(elementName + " is long pressed", true);
	}

	public static void swipe(Swipe swipe) {
		if (DriverManager.getAppiumDriver() instanceof AndroidDriver) {
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: swipeGesture",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction",
							swipe.name().toLowerCase(), "percent", 1));
		} else {
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: swipe",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction",
							swipe.name().toLowerCase(), "percent", 1));
		}
	}

	public static void scrollTillEnd(Scroll scroll) {
		if (DriverManager.getAppiumDriver() instanceof AndroidDriver) {
			boolean istrue;
			do {
				istrue = (boolean) ((JavascriptExecutor) DriverManager.getAppiumDriver())
						.executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100, "width", 200,
								"height", 200, "direction", scroll.name().toLowerCase(), "percent", 1.0));
			} while (istrue);

		} else {
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: scroll",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction",
							scroll.name().toLowerCase(), "percent", 1.0));
		}
	}

	public static void scrollToElement(WebElement element, Scroll scroll) {
		RemoteWebElement remoteWebElement = (RemoteWebElement) element;
		if (DriverManager.getAppiumDriver() instanceof AndroidDriver) {
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: scrollGesture",
					ImmutableMap.of("elementId", remoteWebElement.getId(), "direction", scroll.name().toLowerCase()));
		} else {
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("mobile: scroll",
					ImmutableMap.of("elementId", remoteWebElement.getId(), "direction", scroll.name().toLowerCase()));
		}
	}

	private static boolean isAndorid() {
		return DriverManager.getAppiumDriver() instanceof AndroidDriver;
	}

	private static boolean isIOS() {
		return DriverManager.getAppiumDriver() instanceof IOSDriver;
	}

}
