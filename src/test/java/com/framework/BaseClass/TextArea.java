package com.framework.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea {

	WebDriver driver;
	WebElement element;

	public TextArea(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElement(By.xpath(locator));
	}

	/*
	 * Description: This method clear the content of the text field and enter the
	 * given text. Example: setText("Saikumar")
	 */
	public void setValue(String text) {
		element.clear();
		element.sendKeys(text);
	}

	/*
	 * Description: This method returns contents present in the text field
	 */
	public String getValue() {
		return element.getText();
	}

	/*
	 * Description: This method update the content of the text field and enter the
	 * new value. Example: appendText("Updated input")
	 */
	public void appendText(String text) {
		element.sendKeys(text);
	}

}
