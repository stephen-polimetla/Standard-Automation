package com.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGSeleniumTest {

    @Test
    public void exampleDotComTitle() {
        // Requires chromedriver in PATH or set webdriver.chrome.driver system property.
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://example.com/");
            String title = driver.getTitle();
            Assert.assertTrue(title.contains("Example Domain"), "Title should contain 'Example Domain'");
        } finally {
            driver.quit();
        }
    }
}
