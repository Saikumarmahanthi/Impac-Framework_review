package com.framework.Tests;

import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.Pages.PlaybookList;

import com.framework.Pages.SideNav;

public class PbookList extends BaseTest {

	@Test
	public void tc001() throws InterruptedException {

		SideNav sidenav;
		PlaybookList playBookList;

		Thread.sleep(60 * 1000 * 2);
		// Open Side Navigation bar and click on Playbook link
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");
		

		// Click on "Create Playbook" button in Playbook list page
		playBookList = new PlaybookList(driver);
		Thread.sleep(5000);
		//playBookList.tab("Inactive");
		
		
		
		
		playBookList.table().getCell(1, 6).click();
		Thread.sleep(3000);
		playBookList.table().hoverIcons("duplicated", "Ellipsis").click();
		Thread.sleep(3000);
		playBookList.table().ellipsis("Duplicate PlayBook").click();

		// playBookList.tab("").confirm();

//		playBookList.filter().button().click();
//		playBookList.filter().select("Running").click();
//		Thread.sleep(3000);
//		playBookList.filter().select("ABORTED").click();
//
//		playBookList.filter().select("PCI v3.2.1").click();
//		playBookList.filter().selectAll("Status").click();
//		playBookList.filter().selectAll("Framework").click();
//		playBookList.filter().dropdown(4).click();
//		playBookList.filter().selectDropdown("Equal to").click();
//		Thread.sleep(5000);
//		playBookList.filter().dropdown(6).click();
//		playBookList.filter().selectDropdown("Greater Than").click();
//		playBookList.filter().text(4).setText("20");
//		playBookList.filter().text(6).setText("30");
//		playBookList.filter().button("Confirm").click();
//		playBookList.filter().text(6).setText("50");
//		playBookList.filter().text(6).setText("50");
		// playBookList.search().setText("duplicated");

		Thread.sleep(5000);

		// playBookList.sort().click();
//		Thread.sleep(5000);
//		playBookList.selectSort("Sort by Compliance: Low to High").click();
//
//		playBookList.search().click();
//
//		
//		
//		playBookList.table().pagination("Next").click();
//		playBookList.table().pagination("Previous").click();
//		playBookList.table().pagination("5").click();

//		playBookList.table().hoverIcons("duplicated", "pin").click();

//		

//		playBookList.playbook("Test Duplicate").getText();
//		System.out.print(rowData);
//		playBookList.playBook("playbook1").get("Frequency"); // Returns value from "Frequency" column for given playbook
//	playbookList().playBook("playbook1").run().click();
//	playbookList().playBook("playbook1").pin().click();
//	playbooklist().playbook("playbook1").duplicate().click();
//	playbookList().playbook("playbook1").executionStatus().getIcon();
		Thread.sleep(10000);
		driver.close();
	}
}
