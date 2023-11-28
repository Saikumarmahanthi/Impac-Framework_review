package com.framework.Pages;

import org.openqa.selenium.WebDriver;

public class PlaybookStudio {

	WebDriver driver;

	public PlaybookStudio(WebDriver driver) {
		this.driver = driver;
	}

	public Describe describe() {
		return new Describe(driver);
	}

	public Plays plays() {
		return new Plays(driver);
	}

	public PlayCreation playCreation() {
		return new PlayCreation(driver);
	}

	public Framework framework() {
		return new Framework(driver);
	}

	public Schedule schedule() {
		return new Schedule(driver);
	}

	public SummaryPage summarypage() {
		return new SummaryPage(driver);
	}

	public EditPlaybook eidtDelete() {
		return new EditPlaybook(driver);
	}

	public PlaybookList playbooklist() {
		return new PlaybookList(driver);
	}


	
}
