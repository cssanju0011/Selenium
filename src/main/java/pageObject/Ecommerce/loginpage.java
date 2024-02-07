package pageObject.Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommerce.AbstractComponents.AbstractComponent;

public class loginpage extends AbstractComponent{
	 
	WebDriver driver;
	
	public loginpage(WebDriver driver)
	{   
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement Email;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement Submit;
	
	public  void loginapplication(String email, String password)
	{
	Email.sendKeys(email);
	Password.sendKeys(password);
	Submit.click();
	
	}
   
	public void url()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}
