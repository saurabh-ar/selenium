import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvertisementWindowHandling_CloseTheAdPopup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		System.out.println("Class 04- Aug -2017, Demostrating AdvertisementClose");
		System.out.println("Open Coupon Duniya website");
		driver.get("https://www.coupondunia.in/");
		
		int count=0;
		
		//wait for maximum
		while(count<10){
			
			try{
				
				driver.findElement(By.xpath("//style[@media='print']//following-sibling::span")).click();
				break;
			}
			
			catch(Throwable t){
				
				//wait for 2 seconds
				Thread.sleep(2000);
				System.out.println("catch count"+ count);
				count++;
			}
			
			
		}

		driver.findElement(By.id("header-search-input")).sendKeys("Rakhi");
		
	}

}
