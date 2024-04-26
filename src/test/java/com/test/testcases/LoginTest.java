package com.test.testcases;

import static org.assertj.core.api.Assertions.assertThat;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.baseclass.BaseClass;
import com.test.customannotations.Author;
import com.test.customannotations.CustomAnnotation;
import com.test.customannotations.Module;
import com.test.driverfactory.DriverManager;
import com.test.listeners.TestListener;
import com.test.ownerinterfaces.IEnvConfigProp;
import com.test.pompages.MenuPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseClass {

	@CustomAnnotation(author = Author.AMOL, module = Module.LOGIN)
	@Test(description = "This is a test method")
	public void loginTest() {
		MenuPage menuPage = new MenuPage(DriverManager.getAppiumDriver());
		IEnvConfigProp prop = ConfigFactory.create(IEnvConfigProp.class);
		String productsText = menuPage.clickHamburgerMenu()
				.clickLoginMenuOption()
				.enterUserName(prop.username())
				.enterUserPassword(prop.password())
				.clickLoginBtn()
				.getProductsText();
		assertThat(productsText).isNotNull().isEqualTo("Product");
	}
}
