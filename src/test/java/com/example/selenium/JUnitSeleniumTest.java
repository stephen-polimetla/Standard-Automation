package com.example.selenium;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JUnitSeleniumTest {

    @Test
    public void exampleDotComTitle() {
        // Requires chromedriver in PATH or set webdriver.chrome.driver system property.
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://example.com/");
            String title = driver.getTitle();
            assertTrue(title.contains("Example Domain"), "Title should contain 'Example Domain'");
        } finally {
            driver.quit();
        }
    }
}
