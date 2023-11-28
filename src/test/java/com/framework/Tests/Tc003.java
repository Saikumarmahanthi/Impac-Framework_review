package com.framework.Tests;

import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.PlaybookStudio;
import com.framework.Pages.SideNav;

public class Tc003 extends BaseTest {
	@Test
	public void tc03() throws InterruptedException {

		SideNav sidenav;
		PlaybookList playBookList;
		PlaybookStudio playBookStudio;
		Thread.sleep(60*1000*2);
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
		playBookStudio.eidtDelete().frame("Play_2").click();
		playBookStudio.eidtDelete().delete("Play_2").click();
		playBookStudio.eidtDelete().popupConform("Confirm").click();
		Thread.sleep(5000);
		playBookStudio.eidtDelete().frame("Play_3").click();
		playBookStudio.eidtDelete().edit("Play_3").click();

//		playBookStudio.eidtDelete().popupConform("confirm").click();
//		playBookStudio.eidtDelete().edit("Play_1").click();
//		playBookStudio.playCreation().name().setText("Play_123");
//		playBookStudio.playCreation().description()
//				.setValue("This Play is created for \n All Accounts \n All Services & \n All Regions");
//		// Select All accounts to be included
//		playBookStudio.playCreation().selectAllAccounts().click();
//		// Open Regions list and select given Region
//		playBookStudio.playCreation().selectRegionsToInclude().click();
//		playBookStudio.playCreation().list().search("regions").setText("us-east");
//		playBookStudio.playCreation().list().select("us-east-2");
//		playBookStudio.playCreation().list().search("regions").setText("us-west");
//		playBookStudio.playCreation().list().select("us-west-1");
//		playBookStudio.playCreation().list().apply().click();
//		// Open Services list and select All Services
//		playBookStudio.playCreation().selectServicesToInclude().click();
//		playBookStudio.playCreation().list().selectAll().click();
//		playBookStudio.playCreation().list().apply().click();
//		playBookStudio.playCreation().create().click();
//
//		playBookStudio.framework().select("CIS", "1.2.0").click();
//		playBookStudio.framework().select("PCI", "3.2.1").click();
//
//		// Click Next button in the footer to proceed to the next page
//
//		playBookStudio.describe().next().click();
//
//		// No changes to be made in Schedule for now as "Skip for Now" is the only and
//		// selected option available
//
//		playBookStudio.schedule().clickRecurring().click();
//		playBookStudio.schedule().clickOn("Weekly").click();
//		playBookStudio.schedule().selectDay("F").click();
//		playBookStudio.schedule().slectClock().click();
//		playBookStudio.schedule().hour(3).click();
//		playBookStudio.schedule().minute(30).click();
//		playBookStudio.schedule().noon("AM").click();
//		playBookStudio.schedule().publish().click();

	}

}
