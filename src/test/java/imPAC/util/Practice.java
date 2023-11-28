package imPAC.util;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.framework.Pages.PlaybookList;
import com.framework.Pages.SideNav;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://localhost:5173");
		SideNav sidenav;
		Thread.sleep(60 * 1000 * 2);
		// Open Side Navigation bar and click on Playbook link
		sidenav = new SideNav(driver);
		sidenav.click("Playbook");
		PlaybookList playBookList = new PlaybookList(driver);
		Thread.sleep(5000);
		playBookList.sort().click();
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//div[@class='tabs_wrapper']//button[2]"));
		element.click();
		
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		action.click();

		driver.findElement(By.xpath("//button[text()='Active']")).click();
		WebElement ele = driver.findElement(By.xpath("//input[@class='percentage-input']/../../../*[4]/*[2]"));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).build().perform();
		ele.click();
		Thread.sleep(5000);
		ele.sendKeys("20");

		driver.findElement(By.xpath("//div[text()='Health']/../div[3]/../div[6]/div[2]")).sendKeys("30");

		driver.findElement(By.xpath("//div[text()='Running']//..//img")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='New']//..//img")).click();

//		WebElement ele1 = driver.findElement(By.xpath("//div[text()='duplicated']/ancestor::tr"));
//		Actions ac = new Actions(driver);
//		ac.moveToElement(ele1).build().perform();
//
		// WebElement ele =
		// driver.findElement(By.xpath("//div[text()='duplicated']/ancestor::tr//img[@alt='Pin']"));

//	        // Example: Get data from a table
//	        getDataFromTable(driver);
//	        Thread.sleep(10000);
//	        // Example: Click on a specific cell in the table
//	        clickTableCell(driver, 2, 6);
//	        clickTableCell(driver, 3, 6);
//	        clickTableCell(driver, 4, 6);
//	        Thread.sleep(10000);
//
//	        // Close the browser
//	        driver.quit();
//	    }
//
//	    // Example method to get data from a table
//	    public static void getDataFromTable(WebDriver driver) {
//	        // Locate the table element using its XPath
//	        WebElement table = driver.findElement(By.xpath("//div[@class='table_wrapper']//tbody"));
//
//	        // Get all rows in the table
//	        List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//	        // Iterate through each row
//	        for (WebElement row : rows) {
//	            // Get all cells in the row
//	            List<WebElement> cells = row.findElements(By.tagName("td"));
//
//	            // Iterate through each cell and print the text
//	            for (WebElement cell : cells) {
//	                System.out.print(cell.getText() + "\t");
//	            }
//	            System.out.println(); // Move to the next line for the next row
//	        }
//	    }
//	 
//	    // Example method to click on a specific cell in the table
//	    public static void clickTableCell(WebDriver driver, int rowIndex, int columnIndex) {
//	        // Build the XPath for the specified cell
//	        String cellXPath = "//div[@class='table_wrapper']//tbody//tr[" + rowIndex + "]//td[" + columnIndex + "]";
//	        
//	        // Locate the cell element and click on it
//	        WebElement cell = driver.findElement(By.xpath(cellXPath));
//	        System.out.println(cell.getText());
//	    }
	}
}