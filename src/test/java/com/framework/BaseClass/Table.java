package com.framework.BaseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Table {
	WebDriver driver;
	WebElement element;

	public Table(WebDriver driver, String locator) {
		this.driver = driver;
		element = driver.findElement(By.xpath(locator));
	}

	/*
	 * Description: This method verifies whether or not the text field is seen on
	 * the screen and returns a boolean value
	 */
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	/*
	 * Description: This method clear the content of the text field and enter the
	 * given text. Example: setText("Saikumar")
	 */
	public void setText(String text) {
		element.clear();
		element.sendKeys(text);
	}

	/*
	 * Description: This method click the content of the text field
	 * 
	 */
	public void click(String label) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click();
	}

	/*
	 * Description: This method get highlighted element presented on the UI
	 * 
	 */
	public Point getActivePage() {
		return element.getLocation();
	}

	/*
	 * Description: This method get All colomn headers presented on Table it returns
	 * the list of elements
	 * 
	 */
	public List<WebElement> getColumnHeaders(String locator) {
		List<WebElement> columnHeaders = driver.findElements(By.xpath(locator));
		return columnHeaders;
	}

	/*
	 * Description: This method get text present on specifeid column presented on
	 * the Table. Return Type: String Text
	 *
	 */
	public String getData(int rowIndex, int columnIndex) {
		element = driver.findElement(
				By.xpath("//div[@class='table_wrapper']//tbody//tr[" + rowIndex + "]//td[" + columnIndex + "]"));
		return element.getText();
	}

	/*
	 * Description: This method click on specifeid column presented on the Table.
	 */
	public void click(int rowIndex, int columnIndex) {
		element = driver.findElement(
				By.xpath("//div[@class='table_wrapper']//tbody//tr[" + rowIndex + "]//td[" + columnIndex + "]"));
		element.click();
	}

	/*
	 * Description: This method click on specifeid column presented on the Table.
	 */
	public WebElement searchTable(String searchData) {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='table_wrapper']//tbody//tr//td"));
		for (WebElement cell : list) {
			if (cell.getText().equals(searchData)) {
				return cell;
			}
		}

		return null;
	}

	/*
	 * Description: This method search specifeid text presented on the Table.
	 */
	public void getHeaders(String locators) {
		List<WebElement> thead1 = driver.findElements(By.xpath(locators));
		for (WebElement cell : thead1) {
			String cellValue = cell.getText();
		}
	}

}
