package com.framework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.BaseClass.BaseTest;
import com.framework.Pages.CheckboxList;
import com.framework.Pages.Describe;
import com.framework.Pages.Framework;
import com.framework.Pages.PlayCreation;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.Plays;
import com.framework.Pages.Schedule;
import com.framework.Pages.SideNav;

public class SideNavTest extends BaseTest {
	/*
	 * Verify that when hovered,labels associated with the icons are displayed in
	 * the order and that when clicked on each of the links,the corresponding module
	 * gets opened
	 */
	@Test
	public void snTc01() throws InterruptedException {
		Thread.sleep(60 * 1000 * 2);
		SideNav sidenav = new SideNav(driver);
		sidenav.click("Dashboard");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("dashboard"));
		sidenav.click("Asset");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("cloud-assets"));
		sidenav.click("Playbook");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("playbook"));
		sidenav.click("Time Machine");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("time-machine"));
		sidenav.click("Notifications");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("notification"));
		sidenav.click("Settings");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("settings"));
		sidenav.click("Support");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("support"));
		sidenav.click("Profile");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("profile"));
	}

	/*
	 * Verify that the Side Nav Bar is displayed properly using the Styling with
	 * corresponding icons
	 * 
	 */
	@Test
	public void snTc02() {
		SideNav sidenav = new SideNav(driver);
		System.out.println(sidenav.getIcon("Dashboard"));
		System.out.println(sidenav.getIcon("Asset"));
		Assert.assertEquals(true, sidenav.getIcon("Dashboard").contains("Dashboard.svg"));
		Assert.assertEquals(true, sidenav.getIcon("Asset").contains("CloudAssets.svg"));
		Assert.assertEquals(true, sidenav.getIcon("Playbook").contains("playbook.svg"));
		Assert.assertEquals(true, sidenav.getIcon("Time Machine").contains("timeMachine.svg"));
		Assert.assertEquals(true, sidenav.getIcon("Notifications").contains("notification.svg"));
		Assert.assertEquals(true, sidenav.getIcon("Settings").contains("settings.svg"));
		Assert.assertEquals(true, sidenav.getIcon("Support").contains("support.svg"));
		Assert.assertEquals(true, sidenav.getIcon("Profile").contains("profile.svg"));
	}

	/*
	 * Verify that whenever available, the updated user profile image is displayed
	 * in the Side Nav Bar
	 */
	@Test
	public void snTc03() throws InterruptedException {

		// schedule.publish().click();
	}
}
