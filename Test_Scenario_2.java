package com.testmu;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test_Scenario_2 {
	public static void main(String[] args) {
		Thread chrome = new Thread(() -> {
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.testmuai.com/selenium-playground/");
			driver.findElement(By.linkText("Drag & Drop Sliders")).click();

			WebElement drag = driver.findElement(By.xpath("//input[@value='15']"));
			drag.click();

			for (int i = 15; i < 60; i++) {
				drag.sendKeys(Keys.ARROW_RIGHT);
			}

			String value = driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();
			System.out.println("Range value: " + value);
			driver.quit();
		});

		Thread edge = new Thread(() -> {
			WebDriver driver = new EdgeDriver();
			driver.get("https://www.testmuai.com/selenium-playground/");
			driver.findElement(By.linkText("Drag & Drop Sliders")).click();
			WebElement drag = driver.findElement(By.xpath("//input[@value='15']"));
			drag.click();

			for (int i = 15; i < 60; i++) {
				drag.sendKeys(Keys.ARROW_RIGHT);
			}

			String value = driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();
			System.out.println("Range value: " + value);
			driver.quit();
		});

		chrome.start();
		edge.start();
	}
}
