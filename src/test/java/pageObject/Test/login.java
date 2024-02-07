package pageObject.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login {

	@Test
	public void  submitorder()
	{
		
		String productname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("Compliance.gst.123@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sanjay@0011");
		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		
		 WebElement prod = products.stream() .filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst() .orElse(null);
		 
		 prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));

		 Boolean match = cartproducts.stream() .anyMatch(cartproduct ->
		 cartproduct.getText().equalsIgnoreCase(productname));
		 Assert.assertTrue(match);
		 
		driver.findElement(By.cssSelector(".totalRow button")).click();

		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("india");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();

		driver.findElement(By.cssSelector(".action__submit")).click();

		String confirmMessgae = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessgae.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.close();

	}
}
