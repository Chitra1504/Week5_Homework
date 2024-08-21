package week5.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LegalEntity extends ProjectSpecificMethod{
	@Test
	public void newLegalEntity() throws InterruptedException {
		driver.findElement(By.xpath("//*[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//*[@aria-label='View All Applications']")).click();
		Thread.sleep(1000);
		WebElement le=driver.findElement(By.xpath("//*[text()='Legal Entities']"));
		Actions opt=new Actions(driver);
		opt.scrollToElement(le).perform();
		le.click();
		//Create new entity without giving Entity name
		driver.findElement(By.xpath("//*[text()='New']")).click();
		Thread.sleep(2000);
		WebElement cname=driver.findElement(By.xpath("//input[@name='CompanyName']"));
		cname.sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]")).sendKeys("Salesforces");
		WebElement status=driver.findElement(By.xpath("//button[@role='combobox']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", status);
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String field=driver.findElement(By.xpath("//div[@class='fieldLevelErrors']//a")).getText();
		if(field.contains("Legal Entity Name"))
			System.out.println("The alert message is displayed");
		else
			System.out.println("The alert is not displayed");
		
	}
}
