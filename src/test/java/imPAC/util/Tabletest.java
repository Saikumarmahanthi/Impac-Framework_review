package imPAC.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.framework.BaseClass.BaseTest;
import com.framework.Pages.PlaybookList;
import com.framework.Pages.PlaybookStudio;
import com.framework.Pages.SideNav;

public class Tabletest extends BaseTest {
	@Test
	public void test() throws InterruptedException {

		SideNav sidenav;
		PlaybookList playBookList;
		PlaybookStudio playBookStudio;

		Thread.sleep(60 * 1000 * 2);
		// Open Side Navigation bar and click on Playbook link
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");

		// Click on "Create Playbook" button in Playbook list page
		playBookList = new PlaybookList(driver);
		int rowIndex = getRowIndex(driver, "scheduled");
		int colIndex = getColumnIndex(driver, "Frequency");

		if (rowIndex != -1 && colIndex != -1) {
			System.out.println("Row Index: " + rowIndex);
			System.out.println("Column Index: " + colIndex);
		} else {
			System.out.println("Row or Column not found");
		}

		driver.quit();
	}

	private static int getRowIndex(WebDriver driver, String rowValue) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr"));

		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				if (cell.getText().equals(rowValue)) {
					return i;
				}
			}
		}

		return -1; // Row not found
	}

	private static int getColumnIndex(WebDriver driver, String colValue) {
		List<WebElement> headerCells = driver.findElements(By.xpath("//table[@id='myTable']/thead/tr/th"));

		for (int i = 0; i < headerCells.size(); i++) {
			WebElement cell = headerCells.get(i);
			if (cell.getText().equals(colValue)) {
				return i;
			}
		}

		return -1; // Column not found
	}

}
