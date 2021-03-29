package selenium_tests;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Listeners implements ITestListener {


	public static ThreadLocal<Scenario> scenario = new ThreadLocal<Scenario>();


	@Override public void onTestStart(ITestResult arg0) {

	}
	
	//==========================
	// If testNG registers a test as NOT a success then output logs and screenshot
	//==========================	

	@Override public void onTestFailure(ITestResult iTestResult) { log_test_failure( iTestResult);}
	@Override public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {log_test_failure(iTestResult);}
	@Override public void onTestSkipped(ITestResult iTestResult) {log_test_failure(iTestResult);}

	//blank overides
	@Override public void onTestSuccess(ITestResult iTestResult) {}
	@Override public void onFinish(ITestContext arg0) {}
	@Override public void onStart(ITestContext arg0) {


	}

	//==========================
	// Cucumber hook
	//==========================	

	@After
	public void save_cucumber_scenario_details(Scenario scenario) throws Exception{
		
		//Save cucumber scenario details, to be used by testNG listeners
		//Cucumber hook triggers before testNG test-end listeners. 
		//So there is a need to transfer scenario details to testNG listener, 
		//to be included in its functionality.
		Listeners.scenario.set(scenario);


	}

	private String get_stack_trace(ITestResult arg0){

		return ExceptionUtils.getStackTrace(arg0.getThrowable());

	}

	private void log_test_failure(ITestResult iTestResult ){

		

	}


}