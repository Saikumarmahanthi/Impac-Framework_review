package com.framework.BaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public Wait(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // You can adjust the timeout as needed
    }

    // Reusable method for waiting until an element is present
    public WebElement waitForElementPresent(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    // Reusable method for waiting until an element is clickable
    public WebElement waitForElementClickable(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
}
