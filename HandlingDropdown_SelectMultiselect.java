import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HandlingDropdown_SelectMultiselect {


	public static void  main(String [] args) throws InterruptedException{
		System.out.println("TestNG test case1");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/bewosaurabh/Desktop/multiple-dropdown.html");
		
		WebElement multiple_drop =driver.findElement(By.name("cars"));
		Select sel = new Select(multiple_drop);
	
		WebElement simple_drop =driver.findElement(By.name("birds"));
		Select sel2 = new Select(simple_drop);
		
		System.out.println(sel.isMultiple());
		
		List<WebElement> lst = sel2.getOptions();
		
for(WebElement s :lst)	{
	
	System.out.println(s.getText());
	
	
}	
		/*sel.selectByIndex(0);
		sel.selectByIndex(2);
		
		Thread.sleep(3000);
		
		sel.deselectByIndex(2);
		
		WebElement opt = sel.getFirstSelectedOption();
		System.out.println(opt.getText());*/
	}
	
	
	}

