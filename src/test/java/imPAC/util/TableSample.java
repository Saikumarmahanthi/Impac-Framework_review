package imPAC.util;

import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.SideNav;

public class TableSample extends  BaseTest{
@Test	
public  void tc1() throws InterruptedException {
	SideNav sidenav;
	PlaybookList playBookList;
	Thread.sleep(60 * 1000 * 2);
	sidenav = new SideNav(driver);
	sidenav.click("Playbook");
	playBookList = new PlaybookList(driver);
	Thread.sleep(10000);
	String playbook = playBookList.table().playbook("duplicated").getText();
	System.out.print("PlayBook Details " + playbook + "\t");
	driver.navigate().refresh();
	Thread.sleep(10000);
}
}
