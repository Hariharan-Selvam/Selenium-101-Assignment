package com.testmu;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test_Scenario_3 {
	public static void main(String[] args) {
		Thread chrome = new Thread(() -> {
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.testmuai.com/selenium-playground/");
			driver.findElement(By.linkText("Input Form Submit")).click();
			
			driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
			
			WebElement box1 = driver.findElement(By.xpath("//input[@id='name']"));
			String val=box1.getAttribute("validationMessage");
			System.out.println(val);
			if (val.equals("Please fill out this field.")) {
				System.out.println("Asserted Error Message");
			}
			
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hari");
			driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("Hari123@gmail.com");
			driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("Hari123");
			driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Comapany.co");
			driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("www.google.com");
			
			WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
			Select select = new Select(country);
			select.selectByVisibleText("United States");
			
			driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("Chennai");
			driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("No 400 ken road");
			driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("2nd Floor ");
			driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Tamil Nadu");
			driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("600006");
			driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
			
			String last = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
			System.out.println(last);
			if (last.equals("Thanks for contacting us, we will get back to you shortly.")) {
				System.out.println("Success Message validated");
			}
			
			driver.quit();
			
		});

		Thread edge = new Thread(() -> {
			WebDriver driver = new EdgeDriver();
			driver.get("https://www.testmuai.com/selenium-playground/");
			driver.findElement(By.linkText("Input Form Submit")).click();
			
			driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
			
			WebElement box1 = driver.findElement(By.xpath("//input[@id='name']"));
			String val=box1.getAttribute("validationMessage");
			System.out.println(val);
			if (val.equals("Please fill out this field.")) {
				System.out.println("Asserted Error Message");
			}
			
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hari");
			driver.findElement(By.xpath("//input[@id='inputEmail4']")).sendKeys("Hari123@gmail.com");
			driver.findElement(By.xpath("//input[@id='inputPassword4']")).sendKeys("Hari123");
			driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Comapany.co");
			driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("www.google.com");
			
			WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
			Select select = new Select(country);
			select.selectByVisibleText("United States");
			
			driver.findElement(By.xpath("//input[@id='inputCity']")).sendKeys("Chennai");
			driver.findElement(By.xpath("//input[@id='inputAddress1']")).sendKeys("No 400 ken road");
			driver.findElement(By.xpath("//input[@id='inputAddress2']")).sendKeys("2nd Floor ");
			driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Tamil Nadu");
			driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("600006");
			driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
			
			String last = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
			System.out.println(last);
			if (last.equals("Thanks for contacting us, we will get back to you shortly.")) {
				System.out.println("Success Message validated");
			}
			
			driver.quit();
			driver.quit();
		});

		chrome.start();
		edge.start();

	}
}
