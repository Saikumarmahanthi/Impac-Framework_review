package com.framework.Pages;

import org.openqa.selenium.WebDriver;
import com.framework.BaseClass.Button;
import com.framework.BaseClass.TextArea;
import com.framework.BaseClass.TextField;
import com.framework.Utilites.ReadProperties1;

public class Describe {

	WebDriver driver;

	public Describe(WebDriver driver) {
		this.driver = driver;
	}
	/*
	 * Desctiption This method uses the TextFiled Class to enter the playbook name
	 * in the place holder field on the describe page. 
	 * Example :PlaceBook Name: = "Compliance Book"
	 */
	public TextField name() {
		return new TextField(driver, ReadProperties1.getProperty("name"));
	}
	/*
	 * Desctiption This method uses the TextFiled Class to enter the playbook description
	 * in the place holder field on the describe page. 
	 * Example: PlaceBook Description = "This Placebook for Testing Purpose"
	 */
	public TextArea description() {
		return new TextArea(driver, ReadProperties1.getProperty("description"));
	}
	/*
	 * This method uses the Button Class to click the "Next" button on the
	 * describe page.
	 * 
	 */

	public Button next() {
		return new Button(driver, ReadProperties1.getProperty("next"));
	}

	/*
	 * This method uses the Button Class to click the "Cancel" button on
	 * the describe page.
	 * 
	 */
	public Button cancel() {
		return new Button(driver, ReadProperties1.getProperty("back"));
	}

}
