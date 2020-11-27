]\package basics.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();---okkj-[-l>/.]
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String url = "http://xndev.com/display-image/";
		driver.get(url);
		// we need to find Locator of WebElement
		
		// we have to find xpath of chosefile
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		String filePath = "C:\\Users\\shirz\\OneDrive\\Desktop\\marsopic.jpg";
		
		//we have to give the extention of documetn at the end of our filepath like docx or jpg also 
		// befoer that we should give the name of file like in above i give marso pic
	//	 upload the file
		uploadFile.sendKeys(filePath);
	}

}

-