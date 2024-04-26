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

public class MenuPage {

	@AndroidFindBy(accessibility = "open menu")
	@iOSXCUITFindBy(accessibility = "tab bar option menu")
	WebElement hamburgerMenu;
	
	@AndroidFindBy(accessibility = "menu item log in")
	@iOSXCUITFindBy(accessibility = "menu item log in")
	WebElement btnLoginMenuOption;

	public MenuPage(AppiumDriver appiumDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}
	
	public MenuPage clickHamburgerMenu() {
		DriverUtilities.tap(hamburgerMenu, WaitType.CLICKABLE, "Hamburger Menu");
		return this;
	}

	public LoginPage clickLoginMenuOption() {
		DriverUtilities.tap(btnLoginMenuOption, WaitType.CLICKABLE, "Menu item log in");
		return new LoginPage(DriverManager.getAppiumDriver());
	}
}
