package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.BaseClass.Button;
import com.framework.BaseClass.CheckBox;
import com.framework.BaseClass.TextField;

public class CheckboxList {

	WebDriver driver;

	public CheckBox selectOptions;

	public CheckboxList(WebDriver driver) {
		this.driver = driver;
	}
	/*
	 * This method selects an option from the Checkbox list in Play creation Page and clicks on it using
	 * the Checkbox Class.
	 * 
	 */
	public void select(String label) {
		selectOptions = new CheckBox(driver, "//label[@for='" + label + "']");
		selectOptions.click();
	}
	/*
	 * This method selects the all options from the Checkbox list in Play creation Page using the Checkbox Class.
	 * 
	 * 
	 */
	public CheckBox selectAll() {
		return new CheckBox(driver, "//label[@for='select-all']//img");
	}
	/*
	 * This method Clik on "Apply" button in Play creation Page using the Button Class
	 */
	public Button apply() {
		return new Button(driver, "//button[text()='Apply']");
	}
	/*
	 * This method Search the button in Play creation Page using the Button Class
	 */
	public TextField search(String label) {
		return new TextField(driver, "//input[@placeholder='Search " + label + "']");
	}
}
