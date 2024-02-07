package pageObject.Ecommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponent;

public class cartpage extends AbstractComponent{

	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkoutele;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartproducts;

	public cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyproduct (String productname)
	{
		Boolean match = cartproducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productname));
		return match;	
	}


	 public CheckoutPage goToCheckout()
	 {
		 checkoutele.click();
		 return new CheckoutPage(driver);
	 }
	
	
}
