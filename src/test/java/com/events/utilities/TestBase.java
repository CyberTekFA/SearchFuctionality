package com.events.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions actions;
    protected ExtentReports reports;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest testLogger;

    @BeforeTest
    public void setReports(){
        reports = new ExtentReports();
        String filePath = System.getProperty("user.dir")+"//test-output//report.html";
        htmlReporter = new ExtentHtmlReporter(filePath);
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("Environment","Staging");
        reports.setSystemInfo("OS",System.getProperty("os.name"));
        reports.setSystemInfo("QA Engineer","Faiz Amiree");
        htmlReporter.config().setDocumentTitle("Search Functionlity");
        htmlReporter.config().setReportName("Search functionlity Automation");
    }
    @BeforeMethod
    public void  setDriver(){
        driver = Driver.getDriver();
        actions = new Actions(driver);
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void generatingReport(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            String ScreeshotLocation = BrowserUtils.getScreenShot(result.getName());
            testLogger.fail(result.getName());
            testLogger.addScreenCaptureFromPath(ScreeshotLocation);
            testLogger.fail(result.getThrowable());
        }else if (result.getStatus()== ITestResult.SUCCESS){
            testLogger.pass(result.getName());
        }else if(result.getStatus()==ITestResult.SKIP){
            testLogger.skip(result.getName());
            testLogger.skip(result.getThrowable());

        }

    }

    @AfterTest
    public void collectReport(){
        reports.flush();
Driver.closeDriver();
    }
}
