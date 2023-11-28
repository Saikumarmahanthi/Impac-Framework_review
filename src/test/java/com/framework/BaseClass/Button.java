package com.framework.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Button {

	WebDriver driver;
	WebElement element;

	public Button(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElement(By.xpath(locator));
	}

	/*
	 * Description: This method clicks on the specified element
	 */
	public void click() {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		element.click();
	}

	/*
	 * Description: This method verifies whether the given element is displayed or not
	 * Return : Boolean
	 * 
	 */
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	/*
	 * Description: This method return value of the specified attribute_name for the
	 * given element
	 */
	public String getAttribute(String attribute_name) {
		return element.getAttribute(attribute_name);
	}
	public void hover() {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	/*
	 * Description: This method returns contents present in the text field
	 */
	public String getText() {
		return element.getText();
	}
	/*
	 * Description: This method retrives the dimensions of specified element
	 * Example: Hight , width(150,10)
	 */
	public Dimension getDimensions() {
		return element.getSize();
	}
}
