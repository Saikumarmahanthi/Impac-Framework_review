package com.framework.Utilites;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReuseMethods {

	public WebDriver driver;

	public void clickElement(WebElement element, long waitTimeInSecounds) {

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 WebElement elements = null;
		 elements=wait.until(ExpectedConditions.elementToBeClickable(element));
		 elements.click();

	}

	public void set(WebElement element, String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}

	public void select(WebElement element, String text, int n) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
		select.selectByIndex(n);

	}

	public void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public void alertPresent(WebElement element, String text, int n) {

		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();

	}

	public void getText(WebElement element) {
		element.getText();
	}

	public void selectCheckBoxfromList(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
