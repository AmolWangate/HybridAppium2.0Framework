package com.test.extentreports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<>();

	static synchronized void setExtentTest(ExtentTest extentTest) {
		threadLocalTest.set(extentTest);
	}

	public static synchronized ExtentTest getExtentTest() {
		return threadLocalTest.get();
	}

	static synchronized void unload() {
		threadLocalTest.remove();
	}
}
