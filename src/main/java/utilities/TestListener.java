package utilities;


import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.Set;

@Log4j2
public class TestListener implements ITestListener {

	@Attachment(value = "Failed Screen shoot", type = "image/png")
	public byte[] saveScreenshot(WebDriver driver){
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}

	@Override
	public void onFinish(ITestContext context) {
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}
	}

	public void onTestStart(ITestResult result) { 

	}

	public void onTestSuccess(ITestResult result) {   }

	public void onTestFailure(ITestResult result) {
		log.error("Class Name: "+result.getTestClass().getName() +"."+result.getMethod().getMethodName());
		try{saveScreenshot(UIHelper.threadLocalDriver.get());}catch (Exception e){}
	}

	public void onTestSkipped(ITestResult result) {   }

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

	public void onStart(ITestContext context) { 
	}
}  


