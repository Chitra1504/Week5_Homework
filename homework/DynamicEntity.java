package week5.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DynamicEntity extends ProjectSpecificMethod {
	@DataProvider(name="getData")
	public String[][] setValue(){
		String[][] data=new String[2][3];
		data[0][0]="Salesforce Automation by Chitra";
		data[0][1]="TestLeaf";
		data[0][2]="Salesforces";
		data[1][0]="Salesforce Automation by Ram";
		data[1][1]="TestLeaf";
		data[1][2]="Salesforces";
		return data;		
	}

	@Test(dataProvider="getData")
	public void newLegalEntity(String name,String cmpname,String des ) throws InterruptedException {
		driver.findElement(By.xpath("//*[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//*[@aria-label='View All Applications']")).click();
		Thread.sleep(1000);
		WebElement le=driver.findElement(By.xpath("//*[text()='Legal Entities']"));
		Actions opt=new Actions(driver);
		opt.scrollToElement(le).perform();
		le.click();
		//Create new entity with giving Entity name
		driver.findElement(By.xpath("//*[text()='New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		WebElement cname=driver.findElement(By.xpath("//input[@name='CompanyName']"));
		cname.sendKeys(cmpname);
		driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]")).sendKeys(des);
		WebElement status=driver.findElement(By.xpath("//button[@role='combobox']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", status);
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String field=driver.findElement(By.xpath("//*[@slot='primaryField']")).getText();
		if(field.contains(name))
			System.out.println("The entity is created");
		else
			System.out.println("The entity is not created");
		
	}

}
