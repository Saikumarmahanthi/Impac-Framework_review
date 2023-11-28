package com.framework.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.PlaybookStudio;
import com.framework.Pages.SideNav;

public class PlaybookListCases extends BaseTest {
	@Test(priority = 1)
	public void testCase_1() throws InterruptedException {

		SideNav sidenav;
		PlaybookList playBookList;

		Thread.sleep(60 * 1000 * 2);
		// Open Side Navigation bar and click on Playbook link
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");

		playBookList = new PlaybookList(driver);

		// Click on "Inactive & Active " Tabs for checking Tab Functionality
		playBookList.tab("Inactive");
		playBookList.tab("Active");

		// Click on "Sort based on High & low " condtions for checking Tab Functionality
		playBookList.sort().click();
		playBookList.selectSort("Sort by Compliance: Low to High").click();
		Thread.sleep(5000);
		playBookList.sort().click();
		playBookList.selectSort("Sort by Health: High to Low").click();
		Thread.sleep(5000);

		// Click On the "Filter" button. To filter the Playbook based on a selection,
		playBookList.filter().button().click();
		playBookList.filter().select("ABORTED").click();
		playBookList.filter().select("Running").click();
		playBookList.filter().dropdown(4).click();
		Thread.sleep(3000);
		playBookList.filter().selectDropdown("Equal to").click();
		Thread.sleep(3000);
		// playBookList.filter().text(4).setText("30");
		playBookList.filter().dropdown(6).click();
		playBookList.filter().selectDropdown("Greater Than").click();
		// playBookList.filter().text(6).setText("20");
		Thread.sleep(5000);
		playBookList.filter().selectAll("Framework").click();
		playBookList.filter().select("PCI v3.2.1").click();
		playBookList.filter().button("Confirm").click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(10000);
	}

// This Test get Playbook detais based on Playbook Name
	@Test(priority = 4)
	public void testCase_2() throws InterruptedException {

		SideNav sidenav;
		PlaybookList playBookList;
		// Open Side Navigation bar and click on Playbook link
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");
		playBookList = new PlaybookList(driver);
		Thread.sleep(10000);
		String playbook = playBookList.table().playbook("duplicated").getText();
		System.out.print("PlayBook Details " + playbook + "\t");
		driver.navigate().refresh();
		Thread.sleep(10000);
	}

	// This test is intended to modify the existing Playbook details based on the
	// Playbook Name.
	@Test(priority = 2)
	public void testCase_3() throws InterruptedException {
		SideNav sidenav;
		PlaybookList playBookList;
		PlaybookStudio playBookStudio;
		// Open Side Navigation bar and click on Playbook link
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");
		playBookList = new PlaybookList(driver);
		Thread.sleep(5000);
		playBookList.table().getCell(4, 6).click();		
		Thread.sleep(3000);
		playBookList.table().hoverIcons("Playbook infinite", "Ellipsis").click();
		playBookList.table().ellipsis("Edit PlayBook").click();
		playBookStudio = new PlaybookStudio(driver);
		playBookStudio.describe().description().setValue("This is for Editing Existing Playbook For Testing");
		playBookStudio.plays().open();
		// Create multiple Plays
		int count = 2;
		for (int i = 0; i < count; i++) {
			// Create Play with given Name and Description
			playBookStudio.plays().createPlay().click();
			playBookStudio.playCreation().name().setText("EditPlay_" + i);
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
		Thread.sleep(5000);
		playBookStudio.framework().selectAll().click();
		// Verify that Checkbox state for "Select All" option gets updated based on
		// selection - empty, full selection, partial selection
		playBookStudio.framework().select("CIS v1.2.0").click();
		playBookStudio.describe().next().click();
		playBookStudio.schedule().recurrenceSchedule("Recurring").click();
		playBookStudio.schedule().click("Weekly").click();
		playBookStudio.schedule().select("M").click();
		playBookStudio.schedule().selectClock().click();
		Thread.sleep(3000);
		playBookStudio.schedule().time("03", "hours").click();
		Thread.sleep(3000);
		playBookStudio.schedule().time("00", "minutes").click();
		Thread.sleep(3000);
		playBookStudio.schedule().time("PM", "meridiem").click();
		// Publish the Playbook
		Thread.sleep(5000);
		playBookStudio.schedule().publish().click();
		Thread.sleep(3000);
		Assert.assertEquals(true,
				playBookStudio.summarypage().getMessage().getText().contains("Succesfully created playbook"));

		// Verify that Playbook name is displayed on summary page
		Assert.assertEquals(true,
				playBookStudio.summarypage().getplaybookName().getText().equals("Compliance Playbook"));
		driver.navigate().refresh();
		Thread.sleep(10000);
	}

	@Test(priority =3)
	public void testcase_4() throws InterruptedException {
		SideNav sidenav;
		PlaybookList playBookList;
		PlaybookStudio playBookStudio;
		// Open Side Navigation bar and click on Playbook link
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");
		playBookList = new PlaybookList(driver);
		Thread.sleep(5000);
		playBookList.table().getCell(5, 6).click();
		Thread.sleep(3000);	
		playBookList.table().hoverIcons("scheduled", "Ellipsis").click();
		Thread.sleep(3000);
		playBookList.table().ellipsis("Duplicate PlayBook").click();
		playBookStudio = new PlaybookStudio(driver);
		Thread.sleep(5000);
		playBookStudio.describe().name().setText("Copy of Duplicate");
		playBookStudio.describe().description().setValue("This is for duplicate the Existing Playbook For Testing");
		playBookStudio.plays().open();
		// Create multiple Plays
		int count = 2;
		for (int i = 0; i < count; i++) {
			// Create Play with given Name and Description
			playBookStudio.plays().createPlay().click();
			playBookStudio.playCreation().name().setText("Duplicate_" + i);
			playBookStudio.playCreation().description()
					.setValue("This Play is created for \n All Accounts \n All Services & \n All Regions");

			// Select All accounts to be included
			playBookStudio.playCreation().selectAllAccounts().click();
			playBookStudio.playCreation().selectAllRegions().click();
			// Open Services list and select All Services
			playBookStudio.playCreation().selectServicesToInclude().click();
			playBookStudio.playCreation().list().selectAll().click();
			playBookStudio.playCreation().list().apply().click();

			playBookStudio.playCreation().create().click();
		}
		Thread.sleep(5000);
		playBookStudio.describe().next().click();
		// Verify that Checkbox state for "Select All" option gets updated based on
		// selection - empty, full selection, partial selection
		playBookStudio.framework().select("NIST v800-53.r5").click();
		playBookStudio.describe().next().click();
		playBookStudio.schedule().time("11", "hours").click();
		Thread.sleep(5000);
		playBookStudio.schedule().time("30", "minutes").click();
		Thread.sleep(5000);
		playBookStudio.schedule().time("AM", "meridiem").click();
		// Publish the Playbook
		Thread.sleep(5000);
		playBookStudio.schedule().publish().click();
		Thread.sleep(5000);
		Assert.assertEquals(true,
				playBookStudio.summarypage().getMessage().getText().contains("Succesfully created playbook"));

		// Verify that Playbook name is displayed on summary page
		Assert.assertEquals(true,
				playBookStudio.summarypage().getplaybookName().getText().equals("Compliance Playbook"));
		driver.navigate().refresh();
		Thread.sleep(10000);
	}
}
