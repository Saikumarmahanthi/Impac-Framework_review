package com.framework.Pages;

import org.openqa.selenium.WebDriver;
import com.framework.BaseClass.Button;
import com.framework.BaseClass.CheckBox;
import com.framework.BaseClass.TextArea;
import com.framework.BaseClass.TextField;
import com.framework.Utilites.ReadProperties1;

public class PlayCreation {

	WebDriver driver;

	public PlayCreation(WebDriver driver) {
		this.driver = driver;
	}

	public TextField name() {
		return new TextField(driver, ReadProperties1.getProperty("playName"));
	}

	public TextArea description() {
		return new TextArea(driver, ReadProperties1.getProperty("playdescription"));
	}

	public CheckBox selectAllAccounts() {
		return new CheckBox(driver, ReadProperties1.getProperty("selectallaccounts"));

	}

	public CheckBox selectAllRegions() {
		return new CheckBox(driver, ReadProperties1.getProperty("selectallregions"));

	}

	public CheckBox selectAllServices() {
		return new CheckBox(driver, ReadProperties1.getProperty("selectallservices"));

	}

	public Button selectAccountsToInclude() {
		return new Button(driver, ReadProperties1.getProperty("selectaccountsToInclude"));
	}

	public Button selectServicesToInclude() {
		return new Button(driver, ReadProperties1.getProperty("selectservicesToInclude"));
	}

	public Button selectRegionsToInclude() {
		return new Button(driver, ReadProperties1.getProperty("selectregionsToInclude"));
	}
	
	public Button create() {
		return new Button(driver, ReadProperties1.getProperty("create"));
	}
	
	public CheckboxList list() {
		return new CheckboxList(driver);
	}
	
}
