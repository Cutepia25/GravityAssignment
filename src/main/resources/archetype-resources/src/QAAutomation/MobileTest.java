package com.ecommerce.automation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileTest {
    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.example.app");
        caps.setCapability("appActivity", "com.example.app.MainActivity");
        caps.setCapability("automationName", "UiAutomator2");

        // Initialize Android driver
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void testMobileLogin() {
        // Find and interact with the username field
        MobileElement usernameField = driver.findElementById("com.example.app:id/username");
        usernameField.sendKeys("testuser");

        // Find and interact with the password field
        MobileElement passwordField = driver.findElementById("com.example.app:id/password");
        passwordField.sendKeys("testpassword");

        // Find and click the login button
        MobileElement loginButton = driver.findElementById("com.example.app:id/login");
        loginButton.click();

        // Assert successful login by checking some element on the next screen
        MobileElement homeScreen = driver.findElementById("com.example.app:id/home");
        assert(homeScreen.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
