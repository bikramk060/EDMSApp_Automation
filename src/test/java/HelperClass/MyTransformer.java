package HelperClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.annotations.ITestAnnotation;
import org.testng.IAnnotationTransformer;

public class MyTransformer implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation annotaion, Class testClass, Constructor testConstructor, Method testMethod)
	{
		annotaion.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
