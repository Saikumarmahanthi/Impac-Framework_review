package com.framework.Pages;

import org.openqa.selenium.WebDriver;
import com.framework.BaseClass.Button;
import com.framework.BaseClass.TextField;
import com.framework.Utilites.ReadProperties1;

public class SummaryPage {

	public WebDriver driver;

	public SummaryPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method identifies the Buttons of Create new playbook, Playbook view
	 * Details, Playbook list in playbook created sucessfull page
	 */
	public Button button(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}

	/*
	 * This method get the message of the created playbook 
	 */
	public TextField getMessage() {
		return new TextField(driver, ReadProperties1.getProperty("getmessage"));
	}
	/*
	 * This method get the summary of the created playbook details
	 */
	
	public TextField getsummary() {
		return new TextField(driver, ReadProperties1.getProperty("getsummary"));
	}

	/*
	 * This method get the name of the created playbook
	 */
	public TextField getplaybookName() {
		return new TextField(driver, ReadProperties1.getProperty("playbookName"));
	}
	/*
	 * This method retrieves the images associated with button details.
	 */
	public String getIcon(String label) {
		Button icon = new Button(driver, "//div[text()='" + label + "']//..//img");
		return icon.getAttribute("svg");
	}

	/*
	 * This method close the playbook summary page
	 */
	public Button closeButton() {
		return new Button(driver, ReadProperties1.getProperty("close"));
	}

	/*
	 * This method get playbook image from the playbook summary page
	 */
	public String getImage() {
		Button img = new Button(driver, ReadProperties1.getProperty("playbookImg"));
		return img.getAttribute("svg");
	}
}
