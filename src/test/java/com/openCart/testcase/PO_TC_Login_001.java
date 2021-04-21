package com.openCart.testcase;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;
import com.openCart.Base.BaseClass;
import com.openCart.objects.LoginPageObject;

public class PO_TC_Login_001 extends BaseClass {

	@Test
	public void loginTest_Valid() throws InterruptedException, IOException, DocumentException {
		
		
		driver.get(baseUrl);
		Thread.sleep(3000);
		
		WebElement Setting=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
		WebElement Login=driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Setting.click();
		Login.click();
		
		
		
		LoginPageObject lpo = new LoginPageObject(driver);
		
		lpo.setUserEmail(username);
		lpo.setPassword(password);
		lpo.clickSubmit();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("My Account")) {
			Assert.assertTrue(true);
		
			PdfGenarate(driver, "loginPass"); 
			screenshot(driver, "loginPass");
		} else {
//			screenshot(driver, "loginPass");
			Assert.assertTrue(false);
		}
	}

}
