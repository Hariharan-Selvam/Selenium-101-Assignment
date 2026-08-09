package com.testmu;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test_Scenario_2 {

    // Enter your LambdaTest username here
    static String username = "hariharan072270";

    // Enter your LambdaTest access key here
    static String accessKey = "LT_q748xQb8xZ6UsLeIYNJrIOG3ahoHwTvXq5yE4OVXqXj6DtV";

    static String hubURL = "https://hub.lambdatest.com/wd/hub";

    public static void main(String[] args) throws InterruptedException {

        // =========================
        // CHROME TEST
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
                ltOptions.put("name", "Test_Scenario_2_Chrome");
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
        // EDGE TEST
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
                ltOptions.put("name", "Test_Scenario_2_Edge");
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


        // Start both tests
        chrome.start();
        edge.start();

        // Wait for both tests to finish
        chrome.join();
        edge.join();
    }


    // =========================
    // TEST SCENARIO 2
    // =========================

    public static void executeTest(WebDriver driver) {

        try {

            // Open Selenium Playground
            driver.get(
                "https://www.testmuai.com/selenium-playground/"
            );


            // Click Drag & Drop Sliders
            driver.findElement(
                By.linkText("Drag & Drop Sliders")
            ).click();


            // Find slider with value 15
            WebElement drag = driver.findElement(
                By.xpath("//input[@value='15']")
            );

            drag.click();


            // Move slider from 15 to 60
            for (int i = 15; i < 59; i++) {

                drag.sendKeys(Keys.ARROW_RIGHT);
            }


            // Get final value
            String value = driver.findElement(
                By.xpath("//output[@id='rangeSuccess']")
            ).getText();


            System.out.println(
                "Range value: " + value
            );


            // Validate
            if (value.equals("95")) {

                System.out.println(
                    "Slider validation Passed..."
                );

            } else {

                System.out.println(
                    "Slider validation Failed..."
                );
            }

        } finally {

            driver.quit();
        }
    }
}
