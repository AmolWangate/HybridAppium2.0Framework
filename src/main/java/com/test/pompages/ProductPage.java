package com.test.pompages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.enums.Scroll;
import com.test.enums.WaitType;
import com.test.utilities.DriverUtilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductPage {

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Products']")
	WebElement titleProducts;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Terms of Service | Privacy Policy')]")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Terms of Service | Privacy Policy')]")
	WebElement textTAndC;

	public ProductPage(AppiumDriver appiumDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	public String getProductsText() {
		return DriverUtilities.getText(titleProducts, WaitType.VISIBILE, "Products title");
	}

	public String getTermsAndConditionsText() {
		DriverUtilities.scrollTillEnd(Scroll.DOWN);
		return DriverUtilities.getText(textTAndC, WaitType.VISIBILE, "T&C text");
	}

}
