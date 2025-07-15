
package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utilities.ConfigReader;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeMethod
	public void setUp() {
		// driver = new ChromeDriver();
		// driver.manage().window().maximize();
		String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		// driver.get(url);

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				"reports/ExtentReport.html");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		extent.flush();
	}

	public String takeScreenshot(String testName) {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "screenshots/" + testName + "_" + timestamp + ".png";
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}


}
