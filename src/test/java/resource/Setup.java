package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Setup implements ITestListener {

public static ExtentReports extentReports;
public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

   public void onStart(ITestContext context) {
      String fileName = ExtentReportManager.getReportNameWithTimeStamp();
      String filePath = System.getProperty("user.dir") + "\\reports\\" + fileName;
      extentReports = ExtentReportManager.createInstance(filePath, "Turtlemint curl API report","test automation report");

    }

    public void onTestStart(ITestResult result) {
     ExtentTest test= extentReports.createTest("testName" + result.getTestClass().getName() + "=" + result.getMethod().getMethodName());
     extentTest.set(test);
    }

    public void onTestFailure(ITestResult result) {
       ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
       String stackTrace =  Arrays.toString(result.getThrowable().getStackTrace());
       ExtentReportManager.logFailureDetails(stackTrace);
    }
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }


    }

