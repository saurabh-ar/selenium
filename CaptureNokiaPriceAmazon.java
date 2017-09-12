import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class CaptureNokiaPriceAmazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		System.out.println("Open Amazon Website");
		driver.get("http://www.amazon.com/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nokia",  Keys.ENTER);
		Thread.sleep(4000);
		String xp = "//h2[text()='Nokia 3310 Blue Nokia']/../../../../div[2]/div[1]//span[@class='a-size-base a-color-base']";
		String X = driver.findElement(By.xpath(xp)).getText();
		System.out.println("Nokia 3310 Blue Nokia price is - "+ X);


}
}