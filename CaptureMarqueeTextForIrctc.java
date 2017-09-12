import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureMarqueeTextForIrctc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		System.out.println("Open IRCTC Website");
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

		Thread.sleep(40000); // here we are putting Sleep bcoz if its less the
								// full Marquee will not get Capture. try and
								// see.

		// String X = driver.findElement(By.tagName("marquee")).getText();
		// driver.findElement(By.xpath("//td[@align='left']/../td[2]")).getText();

		// we will not choose below xpath bcoz the alignment can be changed
		// anytime. Cannot be trusted
		// String marqueeText =
		// driver.findElement(By.xpath("//td[@align='right']/preceding-sibling::td[1]")).getText();

		// below xpath uses Launch image. we believe that it will be fixed
		// that's why we use this as anchor to find marquee
		String marqueeText = driver
				.findElement(By.xpath("//img[contains(@src,'launch')]/../../following-sibling::td[1]")).getText();

		System.out.println(marqueeText);
	}

}
