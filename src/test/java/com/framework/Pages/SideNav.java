package com.framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.framework.BaseClass.BaseTest;
import com.framework.BaseClass.Link;

public class SideNav extends BaseTest {

	WebDriver driver;
	WebElement navBar;
	Link navIcon;
	Link navLink;

	public SideNav(WebDriver driver) {
		this.driver = driver;
		navBar = driver.findElement(By.xpath("//div[contains(@class, 'MuiPaper-root')]"));
	}

	public void click(String label) {
		navLink = new Link(driver, "//img[@alt='" + label + "']");
		Actions actions = new Actions(driver);
		actions.moveToElement(navBar).build().perform();
		navLink.click();
	}

	public String getIcon(String label) {
		navIcon = new Link(driver, "//img[@alt='" + label + "']");
		Actions actions = new Actions(driver);
		actions.moveToElement(navBar).build().perform();
		return navIcon.getAttribute("src");

	}

}
