package com.SM.SocialManagementSystem.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplimentationClass implements IRetryAnalyzer{

	int count = 0;
	int retries = 3;
	
	public boolean retry(ITestResult result) {
		if (count<retries) {
			count++;
			return true;
		}
		return false;
	}

}
