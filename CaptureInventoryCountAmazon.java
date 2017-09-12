import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureInventoryCountAmazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		System.out.println("Open Amazon Website");
		driver.get("http://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",  Keys.ENTER);
		Thread.sleep(2000);
		
		String X = driver.findElement(By.id("s-result-count")).getText();
		String[] inventCount = X.split(" ");
		
				System.out.println("Inventory Count for iPhone is  " + inventCount[2]);
	}

}
