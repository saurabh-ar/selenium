import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class CaptureFlightsDetailsMMT {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		System.out.println("Assignment 27- july -2017, Demostrating findelements");
		System.out.println("Open MMT website");
		driver.get("https://www.makemytrip.com/");

		// Clears the Text field
		driver.findElement(By.id("hp-widget__sfrom")).clear();

		// Enter Bangalore in the FROM Text Field
		driver.findElement(By.id("hp-widget__sfrom")).sendKeys("Bangalore, India");

		// Enter Goa in TO Text Field
		driver.findElement(By.id("hp-widget__sTo")).sendKeys("Goa, India");

		// Click SEARCH Button
		driver.findElement(By.id("searchBtn")).click();
		
		//4000ms for Search to execute and display the results
		Thread.sleep(4000);

		// Capture and print 'from' and 'to' from the website
		System.out.println(driver.findElement(By.xpath("//p[@class='flight_dtl_sectors ng-binding']")).getText());

		// Captures total number of flights in the Search
		System.out.println(driver.findElement(By.xpath("//span[@class='light_gray ng-binding ng-scope']")).getText());

		// Scroll down by 4500 pixels so that whole page is visible and Selenium
		// can capture all the Flights in the List
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,4500)", "");

		// Capture all the Flights details
		List<WebElement> Flight = driver.findElements(By.xpath("//span[@class='pull-left airline_info_detls']"));

		// Displays the number of flights captured inside the list
		System.out.println("List size detected  " + Flight.size() + "\n");

		// Declares an iterator to fetch the Entries
		java.util.Iterator<WebElement> it = Flight.iterator();

		//index number
		int index = 1;

		// Print the Flights on the console
		while (it.hasNext()) {

			String flightName = it.next().getText();
			System.out.println("\n" + index + "\n" + flightName);
			index++;

		}

	}

}
