package HelperClass;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	public int iCounter=0;
	public int iRetryLimit=3;

	
	public boolean retry(ITestResult result)
	{
		if(iCounter < iRetryLimit) {
			iCounter++;
			return true;
		}
		return false;
	}
	
	
}
