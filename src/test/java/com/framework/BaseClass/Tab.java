package com.framework.BaseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tab {

	WebDriver driver;
	String label;
	WebElement element;

	public Tab(WebDriver driver, String label) {
		this.driver = driver;
		this.label = label;
	}
	
	/*
	 * Description: This method select tab present in the UI based on given name
	 */
	public Button tab() {
		//return new Button(driver, "//button[text()='" + label + "']"); //build-1 Xpath 
		return new Button(driver, "//div[text()='" + label + "']");// build -2 xpath
	}
}