package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By username = By.xpath("//input[@id = 'userName']");
	By password = By.xpath("//input[@id = 'password']");
	By loginButton = By.xpath("//button[@id = 'login']");
	By logOut = By.xpath("//*[text() = 'Log out']");

	public void login(String user, String pass) {

		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}

	public void validate()
	{
		String expectedUrl= driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl,"https://demoqa.com/profile");

	}

	public void validateLogout()
	{

		WebElement ele = driver.findElement(logOut);
		Assert.assertTrue(ele.isDisplayed(),"LogOut button found");

	}
	public void explicitWait()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(logOut));

	}

	public void getUrl() {

		driver.get("https://demoqa.com/login");
		// loginPage = new LoginPage(driver);
	}
}