package utilities.retryLogic;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

@Log4j2
public class RetryAnalyzer implements IRetryAnalyzer {
    int retryCount = 0;
    int maxRetryCount = 1;

    /* Below method returns 'true' if the test method has to be retried else 'false'
    and it takes the 'Result' as parameter of the test method that just ran */
    String[] ignoreTestCases={"Facebook"};
    public boolean retry(ITestResult result) {
        try {
            String platform = System.getProperty("os");
            if (platform.equalsIgnoreCase("android")) {
                return false;
            }
            for (String testCase : ignoreTestCases) {
                if (result.getName().contains(testCase)) {
                    return false;
                }
            }
            if (retryCount < maxRetryCount) {
                log.info("Retrying " + result.getName() + " test with status "
                        + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
                retryCount++;
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}
