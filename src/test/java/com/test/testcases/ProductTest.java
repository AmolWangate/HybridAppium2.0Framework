package com.test.testcases;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.baseclass.BaseClass;
import com.test.customannotations.Author;
import com.test.customannotations.CustomAnnotation;
import com.test.customannotations.Module;
import com.test.driverfactory.DriverManager;
import com.test.listeners.TestListener;
import com.test.pompages.ProductPage;

@Listeners(TestListener.class)
public class ProductTest extends BaseClass {
	
	@CustomAnnotation(author = Author.JON_DOE, module = Module.PRODUCT)
	@Test(description = "This is a test method")
	public void verifyTAndCText(){
		ProductPage page=new ProductPage(DriverManager.getAppiumDriver());
		String footerTAndCText= page.getTermsAndConditionsText();
		assertThat(footerTAndCText).isNotBlank();
	}

}
