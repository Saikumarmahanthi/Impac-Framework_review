package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.BaseClass.Button;
import com.framework.BaseClass.CheckBox;
import com.framework.BaseClass.Dropdowns;
import com.framework.BaseClass.TextField;

public class Filter {
	WebDriver driver;

	public Filter(WebDriver driver) {
		this.driver = driver;
	}
	public Button button() {
		return new Button(driver, "//div[text()='Filter']");
	}
	public CheckBox select(String label) {
		return new CheckBox(driver, "//div[text()='"+label+"']//..//img");
	}
		
	public CheckBox selectAll(String Label) {
		return new CheckBox(driver, "//div[text()='"+Label+"']/..//div[3]");
	}

	public TextField text(int n) {
		return new TextField(driver, "//div[text()='Compliance']/../div[3]/../div["+n+"]/div[2]");
	}

	public TextField search() {
		return new TextField(driver, "");
	}

	public Button dropdown(int n) {
		return new Button(driver, "//div[text()='Compliance']/../div[3]/../div["+n+"]/div[1]");
	}

	public TextField selectDropdown(String label) {
		return new TextField(driver, "//*[text()='"+label+"']");
	}
	
	
	public Button button(String label) {
		return new Button(driver, "//button[text()='"+label+"']");
	}
	public Button close() {
		return new Button(driver, "");
	}
	
	public CheckBox framework() {
		return new CheckBox(driver, "");
	}

	public CheckBox cloudProvider() {
		return new CheckBox(driver, "");
	}
	
}
