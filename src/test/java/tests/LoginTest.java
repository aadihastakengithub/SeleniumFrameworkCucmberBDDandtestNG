
package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ExcelUtils;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() {

		// driver.get("https://demoqa.com/login");
		LoginPage login = new LoginPage(driver);
		// login.getUrl();
		String user = ExcelUtils.getCellValue("testdata/data.xlsx", "Sheet1", 0,
				0);
		String pass = ExcelUtils.getCellValue("testdata/data.xlsx", "Sheet1", 0,
				1);
		login.login(user, pass);
		test = extent.createTest("Login Test");
		String screenshotPath = takeScreenshot("LoginTest");
		try {
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
