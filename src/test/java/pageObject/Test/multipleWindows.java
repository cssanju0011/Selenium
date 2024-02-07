package pageObject.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleWindows {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/client");

		driver.switchTo().newWindow(WindowType.TAB);
		
		//Want to open a new Window
		//driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		String parentWindowID = it.next();

		String childWindow = it.next();

		driver.switchTo().window(childWindow);

		driver.get("https://www.amazon.com/");

		driver.switchTo().window(parentWindowID);

		WebElement element = driver.findElement(By.id("userEmail"));
	    element.sendKeys("Sanjay");
		
		//how to take element screenshot 
		 File file = element.getScreenshotAs(OutputType.FILE);
		 
		FileUtils.copyFile(file, new File("Elementscreenshot.png")); 
		
		driver.quit();


	}

}
