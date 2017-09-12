import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HtmlWindowHandling_CaptureFacilitaionCenter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		System.out.println("Class Program 03- Aug -2017, Demostrating WindowsHandling");
		System.out.println("Open IRCTC website");
		driver.get("https://www.irctc.co.in//");
		
		//Declare an Action Class object and pass WebDriver object
		Actions act = new Actions(driver);
		
		//Wait for 4 seconds for page to Load
		Thread.sleep(4000);		
				
		//take mouse cursor on Departments dropdown
		act.moveToElement(driver.findElement(By.xpath(".//li/a[@id='irctc_tourism']"))).perform();;
		//Click on 	Prime Music inside Departments
		driver.findElement(By.xpath("//a[text()='Tourist Train']")).click();
		
		//Wait for 4 seconds for page to Load
		Thread.sleep(4000);	
		
		//Storing Window unique IDs inside a SET
		Set<String> set = driver.getWindowHandles();
		System.out.println(set.size());
		
		//Declaring an Iterator to fetch each set
		Iterator<String> it = set.iterator();
		
		//Main window ->  ParentID
		String ParentID = it.next();
		
		//Second window -> ChildID
		String ChildID = it.next();
		
		//pass driver control to child id
		driver.switchTo().window(ChildID);
		
		//Click on 	Prime Music inside Departments
		driver.findElement(By.xpath("//a[text()='Know More']")).click();
		
		//Wait for 4 seconds for page to Load
		Thread.sleep(4000);	
		
		Set<String> set1 = driver.getWindowHandles();
		System.out.println(set.size());
		
		it = set1.iterator();
		ParentID = it.next();
		ChildID = it.next();
		//For Third Window
		String Subchild = it.next();
		
		driver.switchTo().window(Subchild);
		System.out.println(driver.findElement(By.xpath("html/body/center/div/div[2]/center[1]/div[2]/table/tbody/tr[2]/td[2]/font")).getText());
		
		//wait for 2 Seconds
		Thread.sleep(2000);
		
		//Close all the Windows
		driver.quit();

	}

}
