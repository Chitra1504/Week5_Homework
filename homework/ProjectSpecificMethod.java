package week5.homework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {
	public WebDriver driver;
	@BeforeMethod
	@Parameters({"url","uname","passwd"})
	public void preCondition(String url, String uname, String passwd) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login in to Salesforce
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(passwd);
		driver.findElement(By.id("Login")).click();
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
