package com.testmu;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Test_Scenario_3 {

    static String username = "hariharan072270";
    static String accessKey = "LT_q748xQb8xZ6UsLeIYNJrIOG3ahoHwTvXq5yE4OVXqXj6DtV";

    static String hubURL = "https://hub.lambdatest.com/wd/hub";

    public static void main(String[] args) throws InterruptedException {

        // =========================
        // CHROME
        // =========================

        Thread chrome = new Thread(() -> {

            WebDriver driver = null;

            try {

                ChromeOptions options = new ChromeOptions();

                options.setPlatformName("Windows 11");
                options.setBrowserVersion("latest");

                HashMap<String, Object> ltOptions = new HashMap<>();

                ltOptions.put("username", username);
                ltOptions.put("accessKey", accessKey);
                ltOptions.put("build", "Selenium-101-Assignment");
                ltOptions.put("project", "Selenium-101-Assignment");
                ltOptions.put("name", "Test_Scenario_3_Chrome");
                ltOptions.put("selenium_version", "4.8.0");
                ltOptions.put("w3c", true);
                ltOptions.put("video", true);

                options.setCapability("LT:Options", ltOptions);

                driver = new RemoteWebDriver(
                    new URL(hubURL),
                    options
                );

                executeTest(driver);

            } catch (MalformedURLException e) {

                e.printStackTrace();

            } finally {

                if (driver != null) {
                    driver.quit();
                }
            }
        });


        // =========================
        // EDGE
        // =========================

        Thread edge = new Thread(() -> {

            WebDriver driver = null;

            try {

                EdgeOptions options = new EdgeOptions();

                options.setPlatformName("Windows 11");
                options.setBrowserVersion("latest");

                HashMap<String, Object> ltOptions = new HashMap<>();

                ltOptions.put("username", username);
                ltOptions.put("accessKey", accessKey);
                ltOptions.put("build", "Selenium-101-Assignment");
                ltOptions.put("project", "Selenium-101-Assignment");
                ltOptions.put("name", "Test_Scenario_3_Edge");
                ltOptions.put("selenium_version", "4.8.0");
                ltOptions.put("w3c", true);
                ltOptions.put("video", true);

                options.setCapability("LT:Options", ltOptions);

                driver = new RemoteWebDriver(
                    new URL(hubURL),
                    options
                );

                executeTest(driver);

            } catch (MalformedURLException e) {

                e.printStackTrace();

            } finally {

                if (driver != null) {
                    driver.quit();
                }
            }
        });


        // Start both browsers
        chrome.start();
        edge.start();

        // Wait for both tests to finish
        chrome.join();
        edge.join();
    }


    // =========================
    // TEST SCENARIO 3
    // =========================

    public static void executeTest(WebDriver driver) {

        try {

            // Open Selenium Playground
            driver.get(
                "https://www.testmuai.com/selenium-playground/"
            );


            // Click Input Form Submit
            driver.findElement(
                By.linkText("Input Form Submit")
            ).click();


            // Click Submit without entering data
            driver.findElement(
                By.xpath("//button[normalize-space()='Submit']")
            ).click();


            // Validate browser validation message
            WebElement box1 = driver.findElement(
                By.xpath("//input[@id='name']")
            );

            String val = box1.getAttribute(
                "validationMessage"
            );

            System.out.println(
                "Validation Message: " + val
            );


            if (val.equals("Please fill out this field.")) {

                System.out.println(
                    "Asserted Error Message"
                );
            }


            // Enter Name
            driver.findElement(
                By.id("name")
            ).sendKeys("Hari");


            // Enter Email
            driver.findElement(
                By.id("inputEmail4")
            ).sendKeys("Hari123@gmail.com");


            // Enter Password
            driver.findElement(
                By.id("inputPassword4")
            ).sendKeys("Hari123");


            // Enter Company
            driver.findElement(
                By.id("company")
            ).sendKeys("Comapany.co");


            // Enter Website
            driver.findElement(
                By.id("websitename")
            ).sendKeys("www.google.com");


            // Select Country
            WebElement country = driver.findElement(
                By.xpath("//select[@name='country']")
            );

            Select select = new Select(country);

            select.selectByVisibleText(
                "United States"
            );


            // Enter City
            driver.findElement(
                By.id("inputCity")
            ).sendKeys("Chennai");


            // Enter Address 1
            driver.findElement(
                By.id("inputAddress1")
            ).sendKeys("No 400 ken road");


            // Enter Address 2
            driver.findElement(
                By.id("inputAddress2")
            ).sendKeys("2nd Floor");


            // Enter State
            driver.findElement(
                By.id("inputState")
            ).sendKeys("Tamil Nadu");


            // Enter Zip
            driver.findElement(
                By.id("inputZip")
            ).sendKeys("600006");


            // Submit form
            driver.findElement(
                By.xpath("//button[normalize-space()='Submit']")
            ).click();


            // Get success message
            String last = driver.findElement(
                By.xpath("//p[@class='success-msg hidden']")
            ).getText();


            System.out.println(
                "Success Message: " + last
            );


            // Validate success message
            if (last.equals(
                "Thanks for contacting us, we will get back to you shortly."
            )) {

                System.out.println(
                    "Success Message validated"
                );

            } else {

                System.out.println(
                    "Success Message validation Failed"
                );
            }

        } finally {

            driver.quit();
        }
    }
}
