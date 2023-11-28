package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.BaseClass.Button;
import com.framework.BaseClass.TextField;

public class EditPlaybook {
	WebDriver driver;

	public EditPlaybook(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Description: This method Clik on "Edit icon" for particular Paly in Plays Page using the Button Class
	 */
	public Button edit(String palyname) {
		return new Button(driver, "//div[@data-testid='plays-listing' and text()='" + palyname
				+ "']//div[starts-with(@class, '_editIcon')]");
	}
	/*
	 * Description: This method Clik on "Delete icon" for particular Paly in Plays Page using the Button Class
	 */
	public Button delete(String palyname) {
		return new Button(driver, "//div[@data-testid='plays-listing' and text()='" + palyname
				+ "']//div[starts-with(@class, '_deleteIcon')]");
	}
	/*
	 * Description: This method Clik on frame for particular Paly in Plays Page using the Button Class
	 */
	public Button frame(String label) {
		return new Button(driver,"//div[@data-testid='plays-listing' and text()='"+label+"']");
	}
	public Button popupConform(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}

	public Button popupMessage(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}

	public TextField accountsList(String name, int index) {
		return new TextField(driver, "//div[text()='" + name + "']//..//span['" + index + "']");
	}

	public TextField serviceList(String name, int index) {
		return new TextField(driver, "//div[text()='" + name + "']//..//span['" + index + "']");
	}

	public TextField RegionsList(String name, int index) {
		return new TextField(driver, "//div[text()='" + name + "']//..//span['" + index + "']");
	}
}
