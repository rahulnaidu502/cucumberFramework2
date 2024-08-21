package com.vtiger.stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class basesteps {
	
	public static WebDriver driver;
	public static LoginPage lp;
	public static HomePage hp;
	public static LeadPage ldp;
	public static Properties prop;
	public static Map<String,Map<String,String>> dt;
	public static String ScenarioName;
	public static ExtentReports extent;
	public static ExtentTest logger;


	public void readProperties() throws Exception {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		prop.load(fis);
	}

	public void launchApp() throws Exception {

		readExcel();
		System.out.println(dt);
		readProperties();
		if (prop.getProperty("Browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (prop.getProperty("Browser").equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("globaltimeout"))));
		driver.get(prop.getProperty("AppUrl"));

	}

	public void readExcel() throws FilloException {
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/src/test/resources/TestData/data2.xlsx.xlsx");
		String strQuery="Select * from Sheet1";
		Recordset recordset=connection.executeQuery(strQuery);
		List<String> colm = recordset.getFieldNames();

		dt = new HashMap<String,Map<String,String>>();

		while(recordset.next()){
			Map<String,String> rowdata = new HashMap<String,String>();

			for (int i = 0; i<colm.size();i++)
			{
				rowdata.put(colm.get(i),recordset.getField(colm.get(i)));
			}
			dt.put(recordset.getField("ScenarioName"),rowdata);
		}

		recordset.close();
		connection.close();
	}

	public void createExtentReport()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
		//Create an object for Extend Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		extent.setSystemInfo("Environment", "Test2");
		extent.setSystemInfo("User Name", "Rahul N");
		htmlReporter.config().setDocumentTitle("vTiger Regression Report");
		//Name of report
		htmlReporter.config().setReportName("Name of report");
		//Theme
		htmlReporter.config().setTheme(Theme.DARK);


	}

}
