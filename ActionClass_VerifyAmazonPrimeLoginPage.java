import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_VerifyAmazonPrimeLoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		System.out.println("Class Program 31- july -2017, Demostrating ActionClass Use");
		System.out.println("Open Amazon website");
		driver.get("https://www.amazon.com//");
		
		//Declare an Action Class object and pass WebDriver object
		Actions act = new Actions(driver);
		
		//take mouse cursor on Departments dropdown
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Departments']"))).perform();
		
		//take mouse cursor on Amazon music inside Departments
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Amazon Music']"))).perform();
		
		//Click on 	Prime Music inside Departments
		driver.findElement(By.xpath("//span[text()='Prime Music']")).click();
		
		//Wait for 4 seconds for page to Load
		Thread.sleep(4000);		
		
		//Click on TryPrime
		driver.findElement(By.xpath("//a[@id='a-autoid-0-announce']/span")).click();
		
		//Wait for 2 seconds for page to Load
		Thread.sleep(2000);
		
		//Store Title
		String actTitle = driver.getTitle();
		
		//Check for Sign-In Page
		if(actTitle.equals("Amazon Sign In")){
			
			System.out.println("Amazon Prime Signup page verified : Test Case PASS");			
		}
		else{
			System.out.println("Amazon Prime Signup page not verified : Test Case FAIL");
			
		}
		
		//Close WebBrowser
		driver.quit();
	}

}
