import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileUploadHandlingAutoIT_NaukriResumeUpdate {

	public static void main(String[] args) throws InterruptedException, IOException {

		String emailid="saurabh.ar02@gmail.com";
		String pwd = "icecoolx44h";
		
		WebDriver driver = new FirefoxDriver();
		System.out.println(
				"Class 05- Aug -2017, File dwonloading Popup using AutoIT:: Handle Selenium Jar file download");
		System.out.println("Open Selenium Communtity page");
		// Launch the Naukri Website
		driver.get("https://login.naukri.com/nLogin/Login.php?msg=0&URL=http%3A%2F%2Fmy.naukri.com");
		driver.manage().window().maximize();
		//Enter Username
		driver.findElement(By.id("emailTxt")).sendKeys(emailid);
		driver.findElement(By.id("pwd1")).sendKeys(pwd+Keys.ENTER);
		/*Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']")).click();
		*/
		Thread.sleep(2000);
		System.out.println("Login Successful..");
		System.out.println("Clicking on "+ driver.findElement(By.xpath("//b[text()='View and Update Profile']")).getText());
		driver.findElement(By.xpath("//b[text()='View and Update Profile']")).click();
		Thread.sleep(5000);
		System.out.println("Clicking on "+ driver.findElement(By.id("uploadLink")).getText());
		driver.findElement(By.id("uploadLink")).click();
		Thread.sleep(2000);
		System.out.println("Clicking on "+ driver.findElement(By.id("attachCV")).getText());
		driver.findElement(By.id("attachCV")).click();
		System.out.println("Intialiszing AutoIT...");
		Runtime.getRuntime().exec("C:\\Users\\bewosaurabh\\Desktop\\Naukri.exe");
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("attachCVMsg")).getText());
		
		driver.findElement(By.xpath("//b[text()='Save']")).click();

		System.out.println(driver.findElement(By.className("grytxta")).getText());
		
		System.out.println("Bye..Bye..");
		driver.close();
	}

}
