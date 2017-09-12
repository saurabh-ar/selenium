import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureRecommendedNewsOfNYT {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		System.out.println("Open NYT Website");
		driver.get("https://www.nytimes.com/?WT.z_jog=1&hF=f&vS=undefined");

		Thread.sleep(4000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,4500)", "");
		
		String xp = "//div[@class='tab-content recommended']//h2[@class='headline']";
		
		List<WebElement> lst = driver.findElements(By.xpath(xp));

		System.out.println("Output");
		System.out.println("List size " + lst.size());
		int i = 0, index=1;
		while (i < (lst.size())) {
			System.out.println( index + ". " + lst.get(i).getText());
			index++;
			i++;
		}

	}

}
