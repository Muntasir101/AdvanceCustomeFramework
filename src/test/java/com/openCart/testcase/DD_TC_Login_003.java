package com.openCart.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart.Base.BaseClass;
import com.openCart.utilities.Xls_Reader;

public class DD_TC_Login_003 extends BaseClass {


	@Test
	public void LoginTest() throws InterruptedException {

		driver.get(baseUrl);
		Thread.sleep(3000);

		WebElement Setting=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		WebElement Login=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Setting.click();
		Login.click();

		//Excel read data
		Xls_Reader reader = new Xls_Reader("./src/test/java/com/openCart/testdata/loginData.xlsx");
		String sheetName = "Sheet1";

		int rowCount = reader.getRowCount(sheetName);

		for(int rowNum=2; rowNum<=rowCount; rowNum++){
			String loginId = reader.getCellData(sheetName, "email", rowNum);
			String pass = reader.getCellData(sheetName, "password", rowNum);
			
			//Login page
			WebElement email = driver.findElement(By.name("email"));
			WebElement pwd = driver.findElement(By.name("password"));
			WebElement lgnbtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
			
			email.clear();
			email.sendKeys(loginId);
			Thread.sleep(2000);
			
			pwd.clear();
			pwd.sendKeys(pass);
			Thread.sleep(2000);
			
			//lgnbtn.click();
			
		}

	
	}
}
