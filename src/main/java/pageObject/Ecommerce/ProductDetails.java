package pageObject.Ecommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponent;

public class ProductDetails extends AbstractComponent {

	WebDriver driver;

	public ProductDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toastmessage = By.cssSelector("#toast-container");

	public List<WebElement> getproductlist() {

		waitforvisiblelement(productsBy);
		return products;
	}

	public WebElement getproductbyname(String productname) {

		WebElement prod = getproductlist().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addproducttocart(String productname) {
		WebElement prod = getproductbyname(productname);
		prod.findElement(addtocart).click();
		waitforvisiblelement(toastmessage);
		waitforinvisiblelement(spinner);
	}

}
