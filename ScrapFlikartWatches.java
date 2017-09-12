import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrapFlikartWatches {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Launch the firefox browser in maximized window
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com/");
		
		//locate Search box and enter the keywords you want to search
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Timex watches" + Keys.ENTER);
		Thread.sleep(3000);
		
		
//		driver.findElement(By.xpath("//li[text()='Price -- Low to High']")).click();  // uncomment it if you want to sort the results from low to high
//		Thread.sleep(2000);															  // uncomment it if you want to sort the results from low to high
		
		// Creating a File object that represents the disk file. Location is your Project folder : C:\Users\bewosaurabh\selenium-only\SeleniumProjects\
		PrintStream outputFile = new PrintStream(new File("Timex-10.txt"));

		// Store current System.out before assigning a new value
		PrintStream console = System.out;

		// Print on textfile to output stream
		System.setOut(outputFile);
		System.out.println("Search Keyword: Timex Watches");
		
		//intialising local variables
		int k2=0;
		int j = 0;
		int k2last =1;
		
		//pixel value that will be used to scrolll ghe webpage
		int scrollValue = 60;
		
		// k --> is number of Pages: Range [1 to No.ofWebpages in the Result)
		for (int k = 26; k < 68; k++) {
			Thread.sleep(5000);
			
			//Code to press the Next button 
			for (k2 = k2last; k2 < k; k2++) {
				Thread.sleep(5000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				WebElement element = driver.findElement(By.xpath(
						"//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div[10]/div[4]/div"));
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(3000);
				WebElement elementNext = driver.findElement(By.xpath("//span[text()='Next']"));
				elementNext.click();
			}
			k2last=k2;
			
			// j --> number Rows : Range [1 to 11)
			for (j = 1; j < 11; j++) {
				// i --> number of watches : : Range [1 to 5)
				for (int i = 1; i < 5; i++) {
					// save url for returning back to page
					String url = driver.getCurrentUrl();
					
					//try catch to Prevent 'Something is not right. Error : E002' of Flipkart
					try {
						driver.findElement(
								By.xpath("//div[@class='GQtpzo']/div[3]/div[1]/div[" + j + "]/" + "div[" + i + "]"))
								.click();}
					catch (Exception e1) {
						driver.navigate().to(url);
						Thread.sleep(5000);
						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("scroll(0," + scrollValue * j + ")");
						driver.findElement(
								By.xpath("//div[@class='GQtpzo']/div[3]/div[1]/div[" + j + "]/" + "div[" + i + "]"))
								.click();}
						Thread.sleep(3000);
					//Printing the Header of the Watch
					try {
						System.out.println(driver.findElement(By.tagName("h1")).getText());
					} catch (Exception e1) {
						Thread.sleep(2000);
						System.out.println(driver.findElement(By.xpath("//h1")).getText());
					}
					List<WebElement> priceList = driver.findElements(By.xpath("//div[contains(text(), '₹')]"));
					// Declares an iterator to fetch the Entries
					java.util.Iterator<WebElement> it = priceList.iterator();
					// index number
					int index = 1;
					// Print the Item price
					while (true) {

						String itemprice = it.next().getText();
						System.out.println("\n" + "price" + itemprice);
						break;

					}
					List<WebElement> highlightsList = driver
							.findElements(By.xpath("//span[contains(text(), 'Highlights')]/../../div[2]/ul/li"));
					int hlist = highlightsList.size();
					it = highlightsList.iterator();
					System.out.println("Highlights: \n");
					while (hlist >= 1) {

						String highlightText = it.next().getText();
						System.out.println("\n" + highlightText);
						hlist--;
					}
					try {
						// print Description
						System.out.println("Description: \n");
						System.out.println(driver
								.findElement(By.xpath("//span[contains(text(), 'Description')]/../../div[2]/div[1]"))
								.getText());
					} catch (Exception e) {
						System.out.println("Exception Occured : Description unavailable");
					}

					// print Specifications

					System.out.println("Specifications :");
					JavascriptExecutor jse = (JavascriptExecutor) driver;

					try {
						WebElement listReadMore = driver.findElement(By
								.xpath("//*[@id='container']/div/div[1]/div/div/div/div[1]/div/div[2]/div[8]/div[2]"));
						jse.executeScript("arguments[0].scrollIntoView(true);", listReadMore);
					} catch (Exception e) {
						jse.executeScript("scroll(0,100)");
						Thread.sleep(2000);
					}

					try {
						Thread.sleep(3000);
						WebElement readmore = driver
								.findElement(By.xpath("//div[text()='Body Features']/../../../button"));

						// try to Click the Element
						readmore.click();
					} catch (Exception e) {
						System.setOut(console);
						System.out.println("Exception: ReadMore Button Unavailable");
						System.setOut(outputFile);
					}

					List<WebElement> listSpec = driver.findElements(By.xpath("//*[text()='General']/../.."));
					Iterator<WebElement> itSpec = listSpec.iterator();
					// index number
					int indexSpec = listSpec.size();
					// Print the item price

					while (indexSpec > 0) {
						String textGeneral = itSpec.next().getText();
						System.out.println(textGeneral);
						indexSpec--;

					}
					
					// Demarcation-line to Identify different watches
					System.out.println("@@@@@@@@@@@@@@@@@ Watch[ " + j + " ]" + "[ " + i + " ] @@@@@@@@@@@@@@@@@@@");
					// navigate back
					driver.navigate().to(url);
					Thread.sleep(3000);

				}

				if (j < 10) {
					// use javascript to Scroll
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("scroll(0," + scrollValue * j + ")");
				}
				System.setOut(console);
				System.out.println("Row[ " + j + " ]");
				System.setOut(outputFile);
			}
			System.setOut(console);
			System.out.println("Page[ " + k + " ]");
			System.setOut(outputFile);
			j = 1;

		}
	}

}
