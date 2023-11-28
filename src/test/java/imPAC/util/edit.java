package imPAC.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.PlaybookStudio;
import com.framework.Pages.SideNav;

public class edit extends BaseTest {
@Test
private void tes1() throws InterruptedException {
	SideNav sidenav;
	PlaybookList playBookList;
	PlaybookStudio playBookStudio;
	Thread.sleep(60 * 1000 * 2);
	// Open Side Navigation bar and click on Playbook link
	sidenav = new SideNav(driver);
	
	sidenav.click("Playbook");
	playBookList = new PlaybookList(driver);
	Thread.sleep(5000);
	playBookList.table().getCell(1, 6).click();
	Thread.sleep(3000);
	playBookList.table().hoverIcons("duplicated", "Ellipsis").click();
	Thread.sleep(3000);
	playBookList.table().ellipsis("Duplicate PlayBook").click();
//	playBookList.table().hoverIcons("duplicated", "Ellipsis").click();
//	playBookList.table().ellipsis("Edit PlayBook").click();
	playBookStudio = new PlaybookStudio(driver);
	playBookStudio.describe().description().setValue("This is for Editing Existing Playbook For Testing");
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
	playBookStudio.framework().selectAll().click();
	// Verify that Checkbox state for "Select All" option gets updated based on
	// selection - empty, full selection, partial selection
	playBookStudio.framework().select("CIS v1.2.0").click();
	playBookStudio.schedule().recurrenceSchedule("Recurring").click();
	playBookStudio.schedule().click("Weekly").click();
	playBookStudio.schedule().select("M").click();
	playBookStudio.schedule().selectClock().click();
	Thread.sleep(5000);
	playBookStudio.schedule().time("03", "hours").click();
	Thread.sleep(5000);
	playBookStudio.schedule().time("00", "minutes").click();
	Thread.sleep(5000);
	playBookStudio.schedule().time("PM", "meridiem").click();
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
