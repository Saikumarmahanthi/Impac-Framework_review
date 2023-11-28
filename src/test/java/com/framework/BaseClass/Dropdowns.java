package com.framework.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {
	WebDriver driver;
	WebElement element;

	public Dropdowns(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElement(By.xpath(locator));
	}

	/*
	 * Description: This method select the values in the dropdown based on index
	 * specify Example: select.selectByIndex(4);
	 */
	public void selectIndex(int n) {
		Select select = new Select(element);
		select.selectByIndex(n);
	}

	/*
	 * Description: This method select the values in the dropdown based on Value
	 * Example: select.selectByIndex("Accounts");
	 */
	public void selectValue(String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
}
