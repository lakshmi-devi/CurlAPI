package resource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportManager {

    public static  ExtentReports extentReports;

    public static ExtentReports createInstance(String fileName, String reportName,String documentTitle){
        ExtentSparkReporter sparkExtent = new ExtentSparkReporter(fileName);
        sparkExtent.config().setReportName(reportName);
        sparkExtent.config().setDocumentTitle(documentTitle);
        sparkExtent.config().setTheme(Theme.DARK);
        sparkExtent.config().setEncoding("UTF-8");

      extentReports = new ExtentReports();
        extentReports.attachReporter(sparkExtent);
return  extentReports;

    }

    public static String getReportNameWithTimeStamp(){

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        LocalDateTime dateTime = LocalDateTime.now();
        String formatedTime = dateFormat.format(dateTime);
        String reportName = "TestReport"+ " " + formatedTime + ".html";
        return reportName;

    }

    public static void logPassDetails(String log){
    Setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logFailureDetails(String log){
        Setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logInfoDetails(String log){
        Setup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logJson(String json){
        Setup.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }
    public static void logHeaders(List<Header> headerList){
String[][] arrayHeaders  = headerList.stream().map(header -> new String[] {header.getName(), header.getValue()})
                .toArray(String[][]::new);

        Setup.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
    }

}
