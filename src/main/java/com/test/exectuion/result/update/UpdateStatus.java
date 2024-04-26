package com.test.exectuion.result.update;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;

import com.test.driverfactory.DriverManager;
import com.test.enums.Mode;

public final class UpdateStatus {

	private static final Logger LOG = LogManager.getLogger();

	private UpdateStatus() {

	}

	public static void updateExectionStatus(Mode mode, ITestResult result) {
		String status = result.isSuccess() ? "passed" : "failed";
		if (mode.equals(Mode.BROWSERSTACK)) {
			/*
			 * LOG.info("updating exectuion status on browserstack"); final
			 * JavascriptExecutor jse = DriverManager.getAppiumDriver(); JSONObject
			 * executorObject = new JSONObject(); JSONObject argumentsObject = new
			 * JSONObject(); argumentsObject.put("status", status);
			 * argumentsObject.put("reason", result.getThrowable().getMessage());
			 * executorObject.put("action", "setSessionStatus");
			 * executorObject.put("arguments", argumentsObject);
			 * jse.executeScript(String.format("browserstack_executor: %s",
			 * executorObject));
			 */
		} else if (mode.equals(Mode.SAUCELABS)) {
			LOG.info("updating exectuion status on saucelabs");
			((JavascriptExecutor) DriverManager.getAppiumDriver()).executeScript("sauce:job-result=" + status);
		}
	}
}
