package com.framework.Pages;

import org.openqa.selenium.WebDriver;

import com.framework.BaseClass.Button;
import com.framework.BaseClass.Tab;
import com.framework.BaseClass.TextField;
import com.framework.Utilites.ReadProperties1;

public class Plays {

	WebDriver driver;
//	public Tab play_tab;
//	public Button create_play;

	public Plays(WebDriver driver) {
		this.driver = driver;
	}

	public TextField getContent() {
		return new TextField(driver, ReadProperties1.getProperty("getcontext"));
	}

	public Button createPlay() {
		return new Button(driver, ReadProperties1.getProperty("createPlay"));
	}
	
	public void open() {
		new Tab(driver, "Plays").tab().click();
	}
}
