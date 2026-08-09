package com.testmu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test_Scenario_1 {

	public static void main(String[] args) throws InterruptedException {
		Thread chrome = new Thread(() -> {
			WebDriver driver = new ChromeDriver();

			driver.get("https://www.testmuai.com/selenium-playground/");
			driver.findElement(By.linkText("Simple Form Demo")).click();

			if (driver.getCurrentUrl().contains("simple-form-demo")) {
				System.out.println("URL validation Passed...");
			} else {
				System.out.println("URL validation Failed...");
			}
			
			String msg = "Welcome to TestMu AI";
			driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("msg");
			
			driver.findElement(By.xpath("//button[@id='showInput']")).click();
			
			String finalMsg = driver.findElement(By.xpath("//p[@id='message']")).getText();
			if (msg==finalMsg) {
				System.out.println("Same Text was Displayed");
			} else {
				System.out.println("Same Text was Not Displayed");
			}
			driver.quit();
		});

		Thread edge = new Thread(() -> {
			WebDriver driver = new EdgeDriver();
			
			driver.get("https://www.testmuai.com/selenium-playground/");
			driver.findElement(By.linkText("Simple Form Demo")).click();
			
			if (driver.getCurrentUrl().contains("simple-form-demo")) {
				System.out.println("URL validation Passed...");
			} else {
				System.out.println("URL validation Failed...");
			}
			
			String msg = "Welcome to TestMu AI";
			driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("msg");
			
			driver.findElement(By.xpath("//button[@id='showInput']")).click();
			
			String finalMsg = driver.findElement(By.xpath("//p[@id='message']")).getText();
			if (msg==finalMsg) {
				System.out.println("Same Text was Displayed");
			} else {
				System.out.println("Same Text was Not Displayed");
			}
			driver.quit();
		});

		chrome.start();
		edge.start();
	}
}