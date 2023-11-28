package com.framework.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.BaseClass.Button;
import com.framework.BaseClass.Tab;
import com.framework.BaseClass.Table;
import com.framework.BaseClass.TextField;

public class PlaybookList {
	WebDriver driver;

	public PlaybookList(WebDriver driver) {
		this.driver = driver;
	}

	public Tablelist table() {
		return new Tablelist(driver);
	}

	public Filter filter() {
		return new Filter(driver);
	}

	public Button createPlayBook() {
		//return new Button(driver, "//button[text()='Create New Playbook']"); / build-1 Xpath changed to the following
		return new Button(driver, "//button[text()='New Playbook']"); // build-2 Xpath
	}

	public Button sort() {
		return new Button(driver, "//img[@alt='Sort']");
	}

	public Button selectSort(String label) {
		return new Button(driver, "//div[text()='" + label + "']");
	}

	public TextField search() {
		return new TextField(driver, "//input[@class='search_input']");
	}


	public Tab tab(String label) {
		return new Tab(driver, "//button[text()='"+label+"']");
	}

	public Button view() {
		return new Button(driver, "");
	}

	public Button cancel() {
		return new Button(driver, "");
	}

	public Button confirm() {
		return new Button(driver, "");
	}

	public TextField labelText() {
		return new TextField(driver, "");
	}

	public TextField getIcon() {
		return new TextField(driver, "");
	}

}