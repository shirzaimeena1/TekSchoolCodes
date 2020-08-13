package basics.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementAndFindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Set system property for chrome
		// create obj of Webdriver
		// maximize browser
		// set the pageload timeout to 30 sec
		// set timeout to 20 sec
		// delete cookies
		// open Test environment

		System.setProperty("WebDriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("http://tek-school.com/retail/");

		//WebElement desktops = driver.findElement(By.xpath("//a[text()='Desktops']"));
		//desktops.click();
		// Difference between driver.findElement and driver.findElements
		// FindElement
		// finds one element in UI
		// Return type is WebElement
		// Exception : No SuchElemnentFoundException

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		System.out.println(allLinks.size()); // how many links are present in this page

		for ( int i =0; i<allLinks.size(); i++) {
			
		String textOfElements =	allLinks.get(i).getText();// get.text xtract the text of element.
		System.out.println(textOfElements);
		
		if (textOfElements.equals("Desktops")) {
			allLinks.get(i).click();
			break;
		}
		
			
		}
//		 FindEelements
//		 finds many elements with same locator address or xpath or tag
//		 Return type is ArrayList
//		 if no element is found will return an empty List and does not throws
//		 exception
//		
//		
//		 lets take a screenshot of page we opened. 
	// everytime we run screen shod we have to refresh our projic by right clik on projict and and select refresh	
	// at the end of below address we should put(back slash)\\ in order to put our screen shot in the folder.	
	String outputPath = "C:\\Users\\SDET1\\eclipse-workspace\\SeleniumProject.Feb2020\\output\\";
	
	ScreenShotUtility.screenShot(driver, outputPath, "sign pic");
	//ScreenShotUtility.screenShot(driver, outputPath, "TestEnvPic");

	}

}
