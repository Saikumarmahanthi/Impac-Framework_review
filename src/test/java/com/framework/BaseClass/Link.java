package com.framework.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Link extends BaseTest {

	WebElement element;
	WebDriver driver;

	public Link(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElement(By.xpath(locator));
	}

	/*
	 * Description: This method clicks on the specified link
	 */
	public void click() {
		element.click();
	}

	/*
	 * Description: This method return value of the specified attribute_name for the
	 * given element
	 */
	public String getAttribute(String attribute_name) {
		return element.getAttribute(attribute_name);
	}

}
