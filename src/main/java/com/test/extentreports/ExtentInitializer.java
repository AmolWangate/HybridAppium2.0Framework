package com.test.extentreports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.constants.FrameworkConstants;
import com.test.ownerinterfaces.IEnvConfigProp;

public final class ExtentInitializer {

	private static final Logger LOG = LogManager.getLogger();

	private static ExtentReports extentReports;

	private ExtentInitializer() {

	}

	public static void initReport() {
		if (Objects.isNull(extentReports)) {
			LOG.info("Creating extent report");
			extentReports = new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			sparkReporter.config().setDocumentTitle("Automation Report");
			sparkReporter.config().setReportName("Smoke Report");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setEncoding("UTF-8");
			extentReports.attachReporter(sparkReporter);
		}
	}

	public static void flushReport() {
		if (Objects.nonNull(extentReports)) {
			LOG.info("Flushing report");
			extentReports.flush();
			ExtentManager.unload();
			openReportPostExectuion();
		}

	}

	public static void openReportPostExectuion() {
		if (ConfigFactory.create(IEnvConfigProp.class).openreport()) {
			try {
				LOG.info("opening report...");
				Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
			} catch (IOException e) {
				LOG.error(String.format("Report could not be opeded due to %s ", e.getCause()));
				e.printStackTrace();
			}
		}
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
	}

	public static void setAuthor(String userName) {
		ExtentManager.getExtentTest().assignAuthor(userName);
	}

	public static void setCateogry(String category) {
		ExtentManager.getExtentTest().assignCategory(category);
	}

	public static void setDeviceName(String deviceName) {
		ExtentManager.getExtentTest().assignDevice(deviceName);
	}
}
