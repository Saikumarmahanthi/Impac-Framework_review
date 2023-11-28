package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.BaseClass.CheckBox;
import com.framework.BaseClass.Tab;
import com.framework.Utilites.ReadProperties1;

public class Framework {

	public WebDriver driver;

	public Framework(WebDriver driver) {
		this.driver = driver;
	}

	public CheckBox selectAll() {
		return new CheckBox(driver, ReadProperties1.getProperty("selectallframes"));
	}

	public CheckBox select(String framework) {

		return new CheckBox(driver, "//div[text()='" + framework + "']");
	}

	public Tab click() {
		return new Tab(driver, "Framework");
	}
}
