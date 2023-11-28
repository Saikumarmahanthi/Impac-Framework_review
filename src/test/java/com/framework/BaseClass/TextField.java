package com.framework.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextField {
	WebDriver driver;
	WebElement element;

	public TextField(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElement(By.xpath(locator));
	}
	
	/*
	 * Description: This method returns the value of the specified HTML attribute for current field.
	 */
	public String getAttributeValue(String attribute_name) {
		return element.getAttribute(attribute_name);
	}

	/*
	 * Description: This method updates the content of the text field and enter the
	 * new value. Example: appendText("Ramesh")
	 */
	public void appendText(String text) {
		element.clear();
		element.sendKeys(text);
	}

	/*
	 * Description: This method clear text present in the text field.
	 */
	public void clearText() {
		element.clear();
	}

	/*
	 * Description: This method returns hinttext text present in the text field.
	 */
	public String getHintText() {
		return element.getAttribute("placeholder");
	}

	/*
	 * Description: This method returns contents present in the text field
	 */
	public String getText() {
		return element.getText();
	}

	/*
	 * Description: This method verifies whether or not the text field is editable
	 * on the screen and returns a boolean value
	 */
	public boolean isEnabled() {
		return element.isEnabled();
	}

	/*
	 * Description: This method verifies whether or not the text field is seen on
	 * the screen and returns a boolean value
	 */
	public boolean isVisible() {
		return element.isDisplayed();
	}

	/*
	 * Description: This method selects entire contents present in the text field
	 */
	public void selectText() {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a");
	}

	/*
	 * Description: This method clear the content of the text field and enter the
	 * given text. Example: setText("Saikumar")
	 */
	public void setText(String text) {
		element.clear();
		element.sendKeys(text);
	}

	/*
	 * Description: This method click the content of the text field
	 * 
	 */
	public void click() {
		element.click();

	}

}
