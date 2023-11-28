package com.framework.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.PlaybookStudio;
import com.framework.Pages.SideNav;

public class Tc002 extends BaseTest {

	@Test
	public void tc002() throws InterruptedException {
		SideNav sidenav;
		PlaybookList playBookList;
		PlaybookStudio playBookStudio;

		Thread.sleep(60 * 1000 * 2);
		// Open Side Navigation bar and click on Playbook link
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");
		
		// Click on "Create Playbook" button in Playbook list page
		playBookList = new PlaybookList(driver);
		playBookList.createPlayBook().click();
		
		// Input values for each of the tabs and continue to next page
		playBookStudio = new PlaybookStudio(driver);
		playBookStudio.describe().name().setText("Automation demo");
		playBookStudio.describe().description().setValue("This is for testing");
		// playBookStudio.describe().next().click();

		// Navigate to Plays page using tab headers
		playBookStudio.plays().open();
		// Create multiple Plays
		int count = 4;
		for (int i = 1; i < count; i++) {
			// Create Play with given Name and Description
			playBookStudio.plays().createPlay().click();
			playBookStudio.playCreation().name().setText("Play_" + i);
			playBookStudio.playCreation().description()
					.setValue("This Play is created for \n All Accounts \n All Services & \n All Regions");

			// Select All accounts to be included
			playBookStudio.playCreation().selectAllAccounts().click();

			// Open Regions list and select given Region
			playBookStudio.playCreation().selectRegionsToInclude().click();
			playBookStudio.playCreation().list().search("regions").setText("us-east");
			Thread.sleep(3000);
			playBookStudio.playCreation().list().select("us-east-2");
			playBookStudio.playCreation().list().search("regions").setText("us-west");
			playBookStudio.playCreation().list().select("us-west-1");
			playBookStudio.playCreation().list().apply().click();

			// Open Services list and select All Services
			playBookStudio.playCreation().selectServicesToInclude().click();
			playBookStudio.playCreation().list().selectAll().click();
			playBookStudio.playCreation().list().apply().click();

			playBookStudio.playCreation().create().click();
		}
		Thread.sleep(5000);
		playBookStudio.describe().next().click();

		Thread.sleep(3000);
		// Select all frameworks and then exclude two of them from selection
		playBookStudio.framework().selectAll().click();
		// Verify that Checkbox state for "Select All" option gets updated based on
		// selection - empty, full selection, partial selection
		playBookStudio.framework().select("CIS v1.2.0").click();
		playBookStudio.framework().select("PCI v3.2.1").click();

		// Click Next button in the footer to proceed to the next page

		playBookStudio.describe().next().click();

		// No changes to be made in Schedule for now as "Skip for Now" is the only and
		// selected option available

		playBookStudio.schedule().recurrenceSchedule("Recurring").click();
		playBookStudio.schedule().click("Weekly").click();
		playBookStudio.schedule().select("F").click();
		playBookStudio.schedule().selectClock().click();
		Thread.sleep(5000);
		playBookStudio.schedule().time("02", "hours").click();
		Thread.sleep(5000);
		playBookStudio.schedule().time("30", "minutes").click();
		Thread.sleep(5000);
		playBookStudio.schedule().time("PM", "meridiem").click();
		// Publish the Playbook
		playBookStudio.schedule().publish().click();
		Thread.sleep(5000);

		// Verify that playbook is created successfully
		Assert.assertEquals(true,
				playBookStudio.summarypage().getMessage().getText().contains("Succesfully created playbook"));

		// Verify that Playbook name is displayed on summary page
		Assert.assertEquals(true,
				playBookStudio.summarypage().getplaybookName().getText().equals("Compliance Playbook"));

		playBookStudio.summarypage().button("View Playbook Lists").click();
		Thread.sleep(10000);
		playBookStudio.playbooklist().search().setText("Automation demo");

		// playBookStudio.playbooklist().

	}

}
