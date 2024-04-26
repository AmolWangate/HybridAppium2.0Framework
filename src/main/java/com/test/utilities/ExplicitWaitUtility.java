package com.test.utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.constants.FrameworkConstants;
import com.test.customexceptions.InvalidWaitTypeException;
import com.test.driverfactory.DriverManager;
import com.test.enums.WaitType;

public final class ExplicitWaitUtility {

	private ExplicitWaitUtility() {

	}

	public static WebElement performExplicitWait(WebElement element, WaitType type) {
		WebElement webElement = null;
		switch (type) {
		case CLICKABLE:
			webElement = new WebDriverWait(DriverManager.getAppiumDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case VISIBILE:
			webElement = new WebDriverWait(DriverManager.getAppiumDriver(),
					Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
					.until(ExpectedConditions.visibilityOf(element));
			break;
		case NONE:
			webElement = element;
			break;
		default:
			throw new InvalidWaitTypeException(String.format("Provided waitType %s is invalid", type.name()));
		}
		return webElement;
	}
}
