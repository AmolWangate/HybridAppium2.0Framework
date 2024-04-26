package com.test.constants;

import java.io.File;

import org.aeonbits.owner.ConfigFactory;

import com.test.ownerinterfaces.IEnvConfigProp;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final int EXPLICIT_WAIT = 40;
	private static final String USER_DIR_PATH = System.getProperty("user.dir");
	private static final String TEST_RESOURCES_PATH = USER_DIR_PATH + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources";
	private static final String APK_FOLDER_PATH = TEST_RESOURCES_PATH + File.separator + "apk";
	private static final String IPA_FOLDER_PATH = TEST_RESOURCES_PATH + File.separator + "ipa";
	private static final String PROP_FOLDER_PATH = TEST_RESOURCES_PATH + File.separator + "prop";
	private static final String APK_FILE_PATH = APK_FOLDER_PATH + File.separator + "demoapk.apk";
	private static final String IPA_EMULATOR_FILE_PATH = IPA_FOLDER_PATH + File.separator + "demoeios.zip";
	private static final String IPA__FILE_PATH = IPA_FOLDER_PATH + File.separator + "demoeios.zip";
	private static final String ENV_CONFIG__FILE_PATH = PROP_FOLDER_PATH + File.separator + "EnvConfig.properties";
	private static final String EXTENT_FOLDER_PATH = USER_DIR_PATH + File.separator + "Extent-Report";
	private static String extentReportFilePath = "";

	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	public static String getApkFilePath() {
		return APK_FILE_PATH;
	}

	public static String getIpaEmulatorFilePath() {
		return IPA_EMULATOR_FILE_PATH;
	}

	public static String getIpaFilePath() {
		return IPA__FILE_PATH;
	}

	public static String getEnvConfigFilePath() {
		return ENV_CONFIG__FILE_PATH;
	}

	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createExtentReportFilePath();
		}
		return extentReportFilePath;
	}

	private static String createExtentReportFilePath() {
		if (ConfigFactory.create(IEnvConfigProp.class).overridereport()) {
			return EXTENT_FOLDER_PATH + File.separator + "index.html";
		} else {
			return EXTENT_FOLDER_PATH + File.separator + System.currentTimeMillis() + File.separator + "index.html";
		}
	}

}
