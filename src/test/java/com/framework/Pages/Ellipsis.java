package com.framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ellipsis {
	WebDriver driver;
	WebElement element;

	public Ellipsis(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElement(By.xpath(locator));
	}

	public void click() {
		element.click();
	}

}
