package com.SM.SocialManagementSystem.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName + " ---> TestScript Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" ---> Passed");
		Reporter.log(methodName+" ---> TestScript Execution Success");
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("SMS-Report");

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/Society_Management_System/admin/");
		report.setSystemInfo("Reporter Name", "Methaprian S.K");
	}

	public void onTestFailure(ITestResult result) {
		String FailedScript = result.getMethod().getMethodName();

		String fs = FailedScript+"-"+new JavaUtility().getSystemDate();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.edriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ErrorShots/"+fs +".png");
		String filePath = dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(" -- TestScript Execution Failed --");
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" ---> Skipped");
		Reporter.log(" -- TestScript Execution Skipped --");

	}
	public void onFinish(ITestContext context) {
		report.flush();
	}


}
