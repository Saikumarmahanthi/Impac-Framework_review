package com.framework.Tests;

import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.BaseClass.Wait;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.PlaybookStudio;
import com.framework.Pages.SideNav;

public class PlaybookCreation extends BaseTest {

	@Test
	public void pbTcT1() throws InterruptedException {
		SideNav sidenav;
		PlaybookList playBookList;
		PlaybookStudio playBookStudio;
		Wait wait=new Wait(driver);
		Thread.sleep(60 * 1000 * 2);
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");
		Thread.sleep(4000);
		playBookList = new PlaybookList(driver);
		playBookList.createPlayBook().click();
		playBookStudio = new PlaybookStudio(driver);
		playBookStudio.describe().name().setText("Automation demo");
		playBookStudio.describe().description().setValue("This is for testing");
		playBookStudio.plays().open();
		playBookStudio.plays().createPlay().click();
		playBookStudio.playCreation().name().setText("Playname1");
		playBookStudio.playCreation().description()
				.setValue("This Play is created for \n All Accounts \n All Services & \n All Regions");
		playBookStudio.playCreation().selectAllAccounts().click();
		playBookStudio.playCreation().selectAllRegions().click();
		playBookStudio.playCreation().create().click();
		playBookStudio.describe().next().click();
		playBookStudio.framework().selectAll().click();
		playBookStudio.describe().next().click();
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
		Thread.sleep(5000);
		playBookStudio.schedule().publish().click();
		Thread.sleep(5000);
	}
}
