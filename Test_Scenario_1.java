package com.testmu;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test_Scenario_1 {

    // Enter these locally. Do NOT post your access key here.
    static String username = "hariharan072270";
    static String accessKey = "LT_q748xQb8xZ6UsLeIYNJrIOG3ahoHwTvXq5yE4OVXqXj6DtV";

    static String hubURL = "https://hub.lambdatest.com/wd/hub";

    public static void main(String[] args) throws InterruptedException {

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
                ltOptions.put("name", "Test_Scenario_1_Chrome");
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
                ltOptions.put("name", "Test_Scenario_1_Edge");
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


    public static void executeTest(WebDriver driver) {

        // 1. Open Selenium Playground
        driver.get(
            "https://www.testmuai.com/selenium-playground/"
        );


        // 2. Click Simple Form Demo
        driver.findElement(
            By.linkText("Simple Form Demo")
        ).click();


        // 3. Validate URL
        if (driver.getCurrentUrl().contains("simple-form-demo")) {

            System.out.println(
                "URL validation Passed..."
            );

        } else {

            System.out.println(
                "URL validation Failed..."
            );
        }


        // 4. Create String variable
        String msg = "Welcome to TestMu AI";


        // 5. Enter the variable into message box
        driver.findElement(
            By.id("user-message")
        ).sendKeys(msg);


        // 6. Click Get Checked Value
        driver.findElement(
            By.id("showInput")
        ).click();


        // 7. Get displayed message
        String finalMsg = driver.findElement(
            By.id("message")
        ).getText();


        // 8. Validate displayed message
        if (msg.equals(finalMsg)) {

            System.out.println(
                "Same Text was Displayed"
            );

        } else {

            System.out.println(
                "Same Text was Not Displayed"
            );
        }
    }
}
