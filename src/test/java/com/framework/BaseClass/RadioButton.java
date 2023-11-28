package com.framework.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton {

	WebDriver driver;
	WebElement element;

	public RadioButton(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElement(By.xpath(locator));
	}

	/*
	 * Description: This method verifies whether radio button is select or not seen
	 * on the screen and returns a boolean value
	 */
	public boolean selectValue() {
		return element.isSelected();
	}

	/*
	 * Description: This method returns contents present in the text field
	 */
	public String getValue() {
		return element.getText();
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
	 * Description: This method click the radio button of the specified field
	 * 
	 */
	public void click() {
		element.click();
	}

}
