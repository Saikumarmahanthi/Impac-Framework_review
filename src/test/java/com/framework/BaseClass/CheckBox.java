package com.framework.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {

	WebDriver driver;
	// Button tabHeader;
	WebElement element;

	public CheckBox(WebDriver driver, String locator) {
		this.driver = driver;
		// tabHeader = new Button(driver, label);
		element = driver.findElement(By.xpath(locator));
	}

	/*
	 * Description: This method shows given element is enabled or not return type is
	 * True or False
	 */
	public boolean isEnabled() {
		return element.isEnabled();
	}

	/*
	 * Description: This method select given element on the specified Value
	 * 
	 */
	public void select(String[] values) {
		element.click();
	}

	/*
	 * Description: This method click the content of the element
	 * 
	 */
	public void click() {
		element.click();
	}

	/*
	 * Description: This method clear the content of the text field and enter the
	 * given text. Example: setValue("QA_Testing")
	 */
	public void setValue(String text) {
		element.sendKeys(text);
	}

	/*
	 * Description: This method get the Dimensions of the specified element Return
	 * Type: Width, Length
	 */
	public Dimension dimensions() {
		return element.getSize();
	}
}