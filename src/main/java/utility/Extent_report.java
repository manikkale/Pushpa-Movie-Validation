package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_report {
	public static ExtentReports generateReports() {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("myReports.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReport);
		return extent;
		
	}

}
