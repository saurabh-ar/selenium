import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @assignment VerifyYahooLoginElements, 17 July 2017
 * @author ask saurabh (selenium evening batch - old airport road)
 * @version : Selenium 2.52.0.jar
 * 			  Firefox  44.0
 */
public class VerifyYahooLoginElements {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		//Open Yahoo! Login Page
		driver.get("https://login.yahoo.com/");
		

		
		// TC_01 : Yahoo! Image verification
		boolean imgLogoStatus = driver.findElement(By.xpath("//div[@class='login-logo']/img")).isDisplayed();
		
		if (imgLogoStatus) {
			System.out.println("Yahoo! Image verfied : TC_01 = PASS");
		} else {
			System.out.println("Yahoo! Image not verfied : TC_01 = FAIL");
		}
		
		// TC_02 : Verification of CheckBox
		boolean chckBoxStatus=driver.findElement(By.xpath("//span[@class='one-half column stay-signed-in']/input[@id='persistent']")).isSelected();
		
		if (chckBoxStatus) {
			System.out.println("Checkbox verfied : TC_02 = PASS");
		} else {
			System.out.println("Checkbox not verfied : TC_02 = FAIL");
		}
		
		//TC_03 : Verification background-color of Next Button
		String expBckColor	 = 	"rgba(24, 143, 255, 1)";
		String actBckColor	 =	driver.findElement(By.xpath("//input[@id='login-signin']")).getCssValue("background-color");
		
		if (actBckColor.equals(expBckColor)) {
			System.out.println("Background color verified : TC_03 = PASS");
		} else {
			System.out.println("Background color not verified : TC_03 = FAIL");
		}
		
		//TC_04 : BackEnd attribute of TextBox should be "Enter Your Email"
		String expUserLoginText = "Enter your email";
		String actUserLoginText = driver.findElement(By.xpath("//input[@id='login-username']")).getAttribute("placeholder");
		
		if (actUserLoginText.equals(expUserLoginText)) {
			System.out.println("BackEnd attribute of TextBox verified : TC_04 = PASS");
		} else {
			System.out.println("BackEnd attribute of TextBox not verified : TC_04 = FAIL");
		}
		
		
		//TC_05 : When Empty Username Login Textbox clicked Error should be "Sorry, we don't recognize this email."
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		Thread.sleep(1000);
		String expErrorMsg = "Sorry, we don't recognize this email.";
		String actErrorMsg = driver.findElement(By.xpath("//p[@id='username-error']")).getText();
		
		if (actErrorMsg.equals(expErrorMsg)) {
			System.out.println("Error Message Verified : TC_05 = PASS");
		} else {
			System.out.println("Error Message Verified : TC_05 = FAIL");

		}
	
	}

}
