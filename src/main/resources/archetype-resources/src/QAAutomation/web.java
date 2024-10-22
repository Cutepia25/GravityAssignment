package com.ecommerce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class web {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path_to_your_chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Open the e-commerce website login page
        driver.get("https://www.example.com/login");

        // Find and fill in the username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testuser");

        // Find and fill in the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testpassword");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        // Verify successful login by checking some element on the homepage
        WebElement dashboard = driver.findElement(By.id("dashboard"));
        assert(dashboard.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
