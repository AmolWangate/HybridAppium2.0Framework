package com.test.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.customannotations.CustomAnnotation;
import com.test.extentreports.ExtentInitializer;
import com.test.extentreports.ExtentLogger;

public class TestListener implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentInitializer.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentInitializer.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentInitializer.createTest(result.getMethod().getDescription());
		ExtentInitializer.setAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).author());
		ExtentInitializer.setCateogry(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).module());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getThrowable().toString(), true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getThrowable().toString(), true);
	}

}
