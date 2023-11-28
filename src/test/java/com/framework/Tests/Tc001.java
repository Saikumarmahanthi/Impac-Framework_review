package com.framework.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.BaseClass.Wait;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.PlaybookStudio;
import com.framework.Pages.SideNav;

public class Tc001 extends BaseTest {

	@Test
	public void tc001() throws InterruptedException {

		SideNav sidenav;
		PlaybookList playBookList;
		PlaybookStudio playBookStudio;

		Thread.sleep(60 * 1000 * 2);
		// Open Side Navigation bar and click on Playbook link
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");
		
		// Click on "Create Playbook" button in Playbook list page
		playBookList = new PlaybookList(driver);
		Thread.sleep(15000);
		Wait wait =new Wait(driver);
	//	wait.waitForElementPresent();
		playBookList.createPlayBook().click();
		
		// Input values for each of the tabs and continue to next page
		playBookStudio = new PlaybookStudio(driver);
		playBookStudio.describe().name().setText("Automation demo");
		playBookStudio.describe().description().setValue("This is for testing");
		// playBookStudio.describe().next().click();

		// Navigate to Plays page using tab headers
		playBookStudio.plays().open();
		// Create multiple Plays
		int count = 2;
		for (int i = 0; i < count; i++) {
			// Create Play with given Name and Description
			playBookStudio.plays().createPlay().click();
			playBookStudio.playCreation().name().setText("PlayName_" + i);
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
		Thread.sleep(3000);
		playBookStudio.schedule().time("02", "hours").click();
	
		playBookStudio.schedule().time("30", "minutes").click();
	
		playBookStudio.schedule().time("PM", "meridiem").click();
		System.out.println(playBookStudio.schedule().getAlertText());
		playBookStudio.schedule().closeAlert();
		// Publish the Playbook
		Thread.sleep(5000);
		playBookStudio.schedule().publish().click();
		Thread.sleep(5000);

		// Verify that playbook is created successfully
		Assert.assertEquals(true,
				playBookStudio.summarypage().getMessage().getText().contains("Succesfully created playbook"));

		// Verify that Playbook name is displayed on summary page
		Assert.assertEquals(true,
				playBookStudio.summarypage().getplaybookName().getText().equals("Compliance Playbook"));

		playBookStudio.summarypage().button("New Playbook").click();
		playBookStudio.describe().name().setText("Compliance playbook");
		playBookStudio.describe().description().setValue("QA Automation Testing");
		// playBookStudio.describe().next().click();

		// Navigate to Plays page using tab headers
		playBookStudio.plays().open();
		// Create multiple Plays
		int count1 = 3;
		for (int i = 0; i < count1; i++) {
			// Create Play with given Name and Description
			playBookStudio.plays().createPlay().click();
			playBookStudio.playCreation().name().setText("PlayName_" + i);
			playBookStudio.playCreation().description().setValue(
					"This Play is created for \n new 	Playbook Checking \n ALL Services & \n selected Regions \n Accounts");

			// Select All accounts to be included
			playBookStudio.playCreation().selectAllAccounts().click();

			// Open Regions list and select given Region
			playBookStudio.playCreation().selectRegionsToInclude().click();
			playBookStudio.playCreation().list().search("regions").setText("us-east");
			Thread.sleep(3000);
			playBookStudio.playCreation().list().select("us-east-2");
			playBookStudio.playCreation().list().search("regions").setText("global");
			playBookStudio.playCreation().list().select("global");
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
		playBookStudio.framework().select("NIST 800-53.r5").click();

		// Click Next button in the footer to proceed to the next page

		playBookStudio.describe().next().click();

		// No changes to be made in Schedule for now as "Skip for Now" is the only and
		// selected option available

		playBookStudio.schedule().recurrenceSchedule("Recurring").click();
		playBookStudio.schedule().click("Weekly").click();
		playBookStudio.schedule().select("M").click();
		playBookStudio.schedule().selectClock().click();
		Thread.sleep(5000);
		playBookStudio.schedule().time("12", "hours").click();
		Thread.sleep(5000);
		playBookStudio.schedule().time("00", "minutes").click();
		Thread.sleep(5000);
		playBookStudio.schedule().time("AM", "meridiem").click();
		// Publish the Playbook
		Thread.sleep(5000);
		playBookStudio.schedule().publish().click();
		Assert.assertEquals(true,
				playBookStudio.summarypage().button("Create New Playbook").getText().equals("Create New Playbook"));
		Assert.assertEquals(true,
				playBookStudio.summarypage().button("View Playbook Details").getText().equals("View Playbook Details"));
		Assert.assertEquals(true,
				playBookStudio.summarypage().button("View Playbook Lists").getText().equals("View Playbook Lists"));
		Thread.sleep(5000);
	}

	public void tc002() {

	}
}
