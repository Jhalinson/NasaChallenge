package org.deviget.qa.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.deviget.qa.constants.FrameworkPaths;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
/**
 * class to create the test reporte tests
 * @author Jhalinson
 */
public class ExtentReport implements ITestListener {
    // Class variables
    protected static ExtentReports reports;
    protected static ExtentTest test;
    private static String resultPath = getResultPath();
    protected FrameworkPaths frameworkPaths = new FrameworkPaths();


    /**
     * Method to delete a directory if it does not exist
     * @param directory file will be sent
     */
    public static void deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (null != files) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    } else {
                        files[i].delete();
                    }
                }
            }
        }
    }

    /**
     * Method to create a new result path if it does not exist in the directory
     */
    private static String getResultPath() {
        resultPath = "test";
        if (!new File(resultPath).isDirectory()) {
            new File(resultPath);
        }
        return resultPath;
    }

    String ReportLocation = "test-output/Report/" + resultPath + "/";

    @Override
    public void onStart(ITestContext result) {
        reports = new ExtentReports(frameworkPaths.getREPORTPATH());
        test = reports.startTest("");

    }

    @Override
    public void onFinish(ITestContext arg0) {
        reports.endTest(test);
        reports.flush();

    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        test.log(LogStatus.FAIL, "Test is fail");

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        test.log(LogStatus.SKIP, "Test is skipped");

    }

    @Override
    public void onTestStart(ITestResult result) {
        test = reports.startTest(result.getMethod().getMethodName());
        test.log(LogStatus.INFO, result.getMethod().getMethodName());


    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        test.log(LogStatus.PASS, "Test is pass");

    }

}
