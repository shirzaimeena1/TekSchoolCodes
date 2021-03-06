package basics.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadlessBrowser {

	public static void main(String[] args) throws IOException {
		//1. set system property for chrome browser
		// Headles browsers are browswers wchich open but cant see them.
		// usually used in client system
		//fast and not taking any Ui SPACE
		// WE CAN RAN CHROM HEADLEAS, ID AND FAIRFOX HEADLEASE
				System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
				// WE USE CHROME OPTION TO MAKE THE BROWSER HEADLES
				// CHROMEOPTIONS CLASS ENABLE us to add argument and customize our browser we use it make the browser headlese.
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				
				WebDriver driver = new ChromeDriver(options);  // we have to pass options in here in the argument otherwise it wont work.
				
				//3. Set implicit wait for 30 sec
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//4.  maximize browser
				driver.manage().window().maximize();
				//2. open canvas page https://canvas.instructure.com/login/canvas
				driver.get("https://canvas.instructure.com/login/canvas");
				System.out.println(driver.getTitle());
				
				// To find Web Element in UI page we will use .findElement() method
				
				WebElement email = driver.findElement(By.id("pseudonym_session_unique_id"));
				
				// find Webelment for password with using ID for locator
				
				WebElement password = driver.findElement(By.id("pseudonym_session_password"));
				
				// find Webelment for Login button with using ID for locator
				WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/div[2]/button"));
				
				
				// to send a value we will use sendKeys method
				// to click on a button or element we will use .click method
				
				// sends email value
				//email.sendKeys("student@tekschool.us");
				
				String name ="pseudonym_session_unique_id";
				String value = "student@tekschool.us";
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("document.getElementById('" + name + "').value='"+value+"'");
				// sends password value
				password.sendKeys("i am not sharing my password");
				
				// clicks on login button
				loginButton.click();
				String outputPath = "C:\\Users\\shirz\\eclipse-workspace\\Selenium.ProjictFeb2020\\ScreenShot\\";
				
				
				ScreenShotUtility.screenShot(driver, outputPath, "");
				
				driver.close();
				
	}
}