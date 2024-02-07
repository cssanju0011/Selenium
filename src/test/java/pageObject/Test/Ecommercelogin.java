dpackage pageObject.Test;

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

import pageObject.Ecommerce.CheckoutPage;
import pageObject.Ecommerce.ConfirmationPage;
import pageObject.Ecommerce.ProductDetails;
import pageObject.Ecommerce.cartpage;
import pageObject.Ecommerce.loginpage;

@Test
public class Ecommercelogin {

	@SuppressWarnings("unused")

	public void Login() {

		String productname = "ADIDAS ORIGINAL";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		loginpage login = new loginpage(driver);
		login.url();
		login.loginapplication("Compliance.gst.123@gmail.com", "Sanjay@0011");

		ProductDetails selectproduct = new ProductDetails(driver);

		List<WebElement> products = selectproduct.getproductlist();

		selectproduct.addproducttocart(productname);
		selectproduct.gotocartpage();

		cartpage cart = new cartpage(driver);

		Boolean match = cart.verifyproduct(productname);

		Assert.assertTrue(match);

		cart.goToCheckout();
		CheckoutPage checkout = new CheckoutPage(driver);

		checkout.selectcountry("india");
		checkout.submitOrder();
		ConfirmationPage confirm = new ConfirmationPage(driver);
		String confirmMessage = confirm.verifyConfirmmessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.close();

	}
}
