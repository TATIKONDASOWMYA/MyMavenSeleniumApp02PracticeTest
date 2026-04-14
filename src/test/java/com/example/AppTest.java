package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testGoogleTitle() {

        // Headless setup for Jenkins
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Get title
            String title = driver.getTitle();
            System.out.println("Page Title: " + title);

            // Assertion
            assertTrue(title.contains("Google"));

        } finally {
            // Always close browser
            driver.quit();
        }
    }
}
