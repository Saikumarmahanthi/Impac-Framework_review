package imPAC.util;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.framework.Pages.CheckboxList;
import com.framework.Pages.Describe;
import com.framework.Pages.Framework;
import com.framework.Pages.PlayCreation;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.PlaybookStudio;
import com.framework.Pages.Plays;
import com.framework.Pages.Schedule;
import com.framework.Pages.SideNav;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.firefoxdriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver(options);
		WebDriver driver = new FirefoxDriver();

		driver.navigate().to("http://localhost:5173");
		Thread.sleep(10000);
		Actions action = new Actions(driver);

		WebElement ele = driver.findElement(By.xpath("//button[text()='Sign In']"));
		System.out.println(ele.getText());
		action.moveToElement(ele).click().build().perform();
		Thread.sleep(10000);

		WebElement ele2 = driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/form/div/input"));
		action.moveToElement(ele2).click().build().perform();

//		

//
//		// Click on "Create Playbook" button in Playbook list page
//		playBookList = new PlaybookList(driver);
//		playBookList.createPlayBook().click();
//		// Input values for each of the tabs and continue to next page
//		playBookStudio = new PlaybookStudio(driver);
//		playBookStudio.describe().next().click();
//		playBookStudio.describe().next().click();
//		playBookStudio.describe().next().click();
//		playBookStudio.schedule().publish().click();
//		System.out.println(playBookStudio.summarypage().getIcon("Create New Playbook"));

//		System.out.println(playBookStudio.summarypage().getplaybookName().getText());
//		System.out.println(playBookStudio.summarypage().buttonNames("Create New Playbook").getText());
//		System.out.println(playBookStudio.summarypage().buttonNames("View Playbook Details").getText());
//		System.out.println(playBookStudio.summarypage().buttonNames("View Playbook Lists").getText());
//		Assert.assertEquals(true,
//				playBookStudio.summarypage().getMessage().getText().contains("Succesfully created playbook,"));
//		Assert.assertEquals(true,
//				playBookStudio.summarypage().getplaybookName().getText().equals("Compliance Playbook"));
//
//		Assert.assertEquals(true, playBookStudio.summarypage().buttonNames("Create New Playbook").getText()
//				.equals("Create New Playbook"));
//		Assert.assertEquals(true, playBookStudio.summarypage().buttonNames("View Playbook Details").getText()
//				.equals("View Playbook Details"));
//		Assert.assertEquals(true,
//				playBookStudio.summarypage().buttonNames("View Playbook Lists").getText().equals("View Playbook Lists"));

//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
//		SideNav sidenav = new SideNav(driver);
//
//		PlaybookList playBookList;
//		Describe describe;
//		Plays plays;
//		PlayCreation playCreation;
//		CheckboxList cs;
//		Framework framework;
//		Schedule schedule;
//		sidenav.click("Playbook");
//
//		playBookList = new PlaybookList(driver);
//		playBookList.createPlayBook().click();
//
//		describe = new Describe(driver);
//		describe.name().setText("QATest");
//		describe.description().setValue("QA Automation Testing purpose");
//		describe.next().click();

//		plays = new Plays(driver);
//		int num = 2;
//		for (int i = 0; i < num; i++) {
//			plays.create_play.click();
//			playCreation = new PlayCreation(driver);
//			playCreation.name().setText("Test1");
//			playCreation.description().setValue("QA Automation Testing");
//			Thread.sleep(3000);
//			playCreation.selectAccountsToInclude().click();
//			cs = new CheckboxList(driver);
//			cs.selectAll().clickElement();
//			cs.click("413899828174");
//			cs.apply().clickElement();
//			System.out.println(playCreation.selectAccountsToInclude().getText());
//			playCreation.selectRegionsToInclude().click();
//			cs.selectAll().clickElement();
//			cs.click("us-east-2");
//			cs.click("us-east-1");
//			cs.apply().clickElement();
//			System.out.println(playCreation.selectRegionsToInclude().getText());
//			playCreation.selectServicesToInclude().click();
//			cs.selectAll().clickElement();
//			cs.click("IAM_ROLE");
//			cs.apply().clickElement();
//			System.out.println(playCreation.selectServicesToInclude().getText());
//			Thread.sleep(3000);
//			playCreation.create().click();
//		}
//		Thread.sleep(5000);

//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[3]/div[2]/div")).click();
//
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[1]/div/div[1]"))
//				.click();
//		String inc = driver.findElement(By.xpath("//div[text()='Accounts']//..//span[1]")).getText();
//		System.out.println(inc);
//		String ex = driver.findElement(By.xpath("//div[text()='Accounts']//..//span[2]")).getText();
//		System.out.println(ex);
//		String inc1 = driver.findElement(By.xpath("//div[text()='Services']//..//span[1]")).getText();
//		System.out.println(inc1);
//		String ex1 = driver.findElement(By.xpath("//div[text()='Services']//..//span[2]")).getText();
//		System.out.println(ex1);

//		WebElement element = driver.findElement(By.xpath("//button[text()='Create Playbook']"));
//		Dimension d=element.getSize();
//		System.out.println(d.height);
//		System.out.println(d.width);
//		System.out.println(d.getHeight());
//		System.out.println(d.getWidth());		
//		driver.findElement(By.xpath("//button[text()='Plays']")).click();
//		driver.findElement(By.xpath("//button[text()='Create Play']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[text()='Select accounts To Include']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//label[@for='select-all']//img")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//label[@for='573506787709']//img")).click();

		// label[@for='select-all']//img

//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//div[text()='CIS' and text()='1.2.0']//..//../div/img")).click();
//		driver.findElement(By.xpath("//div[text()='Select All Frameworks']//..//img")).click();

//		WebElement ele = driver.findElement(By.xpath("//div[@data-testid='display-createplay-content']"));
//		System.out.println(ele.getText());

//		driver.findElement(By.xpath("//div[text()='Once']")).click();
//		driver.findElement(By.xpath("//div[text()='Recurring']")).click();
//		WebElement ele = driver.findElement(By.xpath("//input[@id='timeInput']"));
//		ele.clear();
//		ele.sendKeys("12:30 PM");
//		WebElement ele2 = driver.findElement(By.xpath("//input[@id='dateInput']"));
//
//		ele2.sendKeys("12-02-2023");
//		// driver.findElement(By.xpath("//input[@id='timeInput']/../img")).click();
//		Thread.sleep(5000);
//		// driver.findElement(By.xpath("//input[@id='dateInput']/../../div[2]")).click();
//
//		// div[text()='Select All']/../../input[@type='checkbox']

//	Thread.sleep(10000);
//	driver.findElement(By.xpath("//span[text()='Select all ' and text() = 'accounts' ]/../../input[@type='checkbox']")).click();
//	driver.findElement(By.xpath("//span[text()='Select all ' and text() = 'regions' ]/../../input[@type='checkbox']")).click();
//	driver.findElement(By.xpath("//span[text()='Select all ' and text() = 'services' ]/../../input[@type='checkbox']")).click();

//		driver.findElement(By.xpath("//button[text()='Describe']")).click();
//		driver.findElement(By.xpath("//button[text()='Plays']")).click();
//		driver.findElement(By.xpath("//button[text()='Create Play']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("test1");
//		driver.findElement(By.xpath("//textarea[@placeholder='Enter purpose']")).sendKeys("test1");
//		driver.findElement(By.xpath("//button[text()='Select Accounts To Include']")).click();
//		SideNav sidenav;
//		PlaybookList playBookList;
//		Schedule schedule;
//		sidenav = new SideNav(driver);
//		sidenav.click("Playbook");
//
//		playBookList = new PlaybookList(driver);
//		playBookList.createPlayBook().click();
//
//		schedule = new Schedule(driver);
//		schedule.clickTab();
//		schedule.clickRecurring().clickRadioButton();
//		schedule.clickOnce().clickRadioButton();
		// schedule.clock().click();
		// schedule.calender().click();
//		schedule.setTime().setText("12:30 PM");
//		schedule.setCalender().setText("25-09-2019");
//		Thread.sleep(5000);
//		schedule.back().click();
	}
}
