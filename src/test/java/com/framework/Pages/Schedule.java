package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.BaseClass.Button;
import com.framework.BaseClass.RadioButton;
import com.framework.BaseClass.Tab;
import com.framework.BaseClass.TextField;

public class Schedule {

	public WebDriver driver;

	public Schedule(WebDriver driver) {
		this.driver = driver;
	}

	public Tab clickTab() {
		return new Tab(driver, "//button[text()='Schedule']");
	}

	public RadioButton click(String label) {
		return new RadioButton(driver, "//div[text()='" + label + "']");
	}

	public Button select(String label) {
		return new Button(driver, "//button[text()='" + label + "']");
	}

	public Button time(String label2, String label1) {
		return new Button(driver, "//ul[@aria-label='Select " + label1 + "']//li[text()='" + label2 + "']");
	}

	public Button selectClock() {
		return new Button(driver, "//button[@type='button']");
	}

	public TextField setTime() {
		return new TextField(driver, "//input[@id='timeInput']");
	}

	public Button selectCalender() {
		return new Button(driver, "//input[@id='dateInput']/../../div[2]");
	}

	public TextField setCalender() {
		return new TextField(driver, "//input[@id='dateInput']");
	}

	public Button publish() {
		return new Button(driver, "//button[text()='Publish']");
	}

	public Button back() {
		return new Button(driver, "//button[text()='Back']");
	}

	public Button recurrenceSchedule(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}
	public String getAlertText() {
		return new TextField(driver, "//div[@class='popup-content']").getText();
	}
	
	public void closeAlert() {
		 new Button(driver,"//button[@class='crossIcon']").click();
	}
	//div[@class='popup-content']
}
