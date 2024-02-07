package pageObject.Ecommerce.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.Ecommerce.loginpage;

@Test
public class BaseTest {

	WebDriver driver;
	public WebDriver initiallizeDriver() throws IOException {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Ecommerce//Resources//globalData.properties");
		pro.load(fis);
		String browsername = pro.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}
	
	
	public loginpage luanchapplication() throws IOException
	{
		driver =initiallizeDriver();
		loginpage login = new loginpage(driver);
		login.url();
		return login;
	}
	
	@AfterTest
	public void closedriver(WebDriver driver)
	
	{
		driver.close();
	}
}

