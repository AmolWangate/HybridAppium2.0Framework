package com.test.pompages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.driverfactory.DriverManager;
import com.test.enums.WaitType;
import com.test.utilities.DriverUtilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage {

	@AndroidFindBy(accessibility = "Username input field")
	@iOSXCUITFindBy(accessibility = "Username input field")
	WebElement inputUserName;

	@AndroidFindBy(accessibility = "Password input field")
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Password input field'")
	WebElement inputPassword;

	@AndroidFindBy(accessibility = "Login button")
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Login button'")
	WebElement btnLogin;

	public LoginPage(AppiumDriver appiumDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	public LoginPage enterUserName(String userName) {
		DriverUtilities.sendKeys(inputUserName, WaitType.VISIBILE, userName, "User input field");
		return this;
	}

	public LoginPage enterUserPassword(String userPassword) {
		DriverUtilities.sendKeys(inputPassword, WaitType.VISIBILE, userPassword, "password input field");
		return this;
	}

	public ProductPage clickLoginBtn() {
		DriverUtilities.tap(btnLogin, WaitType.CLICKABLE, "Login button");
		return new ProductPage(DriverManager.getAppiumDriver());
	}
}
