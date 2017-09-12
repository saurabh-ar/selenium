import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownloadHandling_HadleSeleniumJarDownload {

	public static void main(String[] args) {
		
		
		//Under the Hood : Set Browser Preferences before launching the browser
		FirefoxProfile profile = new FirefoxProfile();
		
		//Goto Firefox-> about:config -> in browser.download.folderList, set Value:2; means save the download in Local drive path
		//					Key		  : Value
		//browser.download.folderList : 0 	-> Desktop
		//browser.download.folderList : 1 	-> Downloads
		//browser.download.folderList : 2 	-> Save to Local Path
		profile.setPreference("browser.download.folderList", 2);
		
		//Google "MIME type for .jar files"-> application/java-archive ; Browser will not show popup incase for .jar files
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/java-archive");
		
		//Local Path
		profile.setPreference("browser.download.dir", "E:\\");
		
		WebDriver driver = new FirefoxDriver(profile);
		System.out.println("Class 05- Aug -2017, File dwonloading Popup using AutoIT:: Handle Selenium Jar file download");
		System.out.println("Open Selenium Communtity page");
		//Launch the selenium Downloads page
		driver.get("http://docs.seleniumhq.org/download/");
		
		driver.findElement(By.linkText("3.4.0")).click();
	}

}
