package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.BaseClass.Button;
import com.framework.BaseClass.Table;
import com.framework.BaseClass.TextField;

public class Tablelist {
	public WebDriver driver;

	public Tablelist(WebDriver driver) {
		this.driver = driver;
	}

	public Button pagination(String label) {
		return new Button(driver, "//button[text()='" + label + "']");
	}

	public TextField playbook(String label) {
		return new TextField(driver, "//div[text()='" + label + "']/ancestor::tr");
	}

	public Table getHeaders() {
		return new Table(driver, "//div[@class='table_wrapper']//tr//th");
	}

	public TextField getCell(int rowIndex, int columnIndex) {
		return new TextField(driver,
				"//div[@class='table_wrapper']//tbody//tr[" + rowIndex + "]//td[" + columnIndex + "]");
	}

	public Button hoverIcons(String playbookName, String iconName) {

		return new Button(driver, "//div[text()='" + playbookName + "']/ancestor::tr//img[@alt='" + iconName + "']");
	}

	public Button ellipsis(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}

	public Button playbookIcon(String playbookName) {

		return new Button(driver, "//div[text()='" + playbookName + "']/ancestor::tr//div[@class='infoIcon']/img");
	}

}
