package com.test.retryanalyzer;

import org.aeonbits.owner.ConfigFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.test.ownerinterfaces.IEnvConfigProp;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count = 0;
	int max = ConfigFactory.create(IEnvConfigProp.class).maxretry();

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (count < max) {
				count++;
				result.setStatus(ITestResult.FAILURE);
				return true;
			} else {
				result.setStatus(ITestResult.FAILURE);
			}
		} else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
