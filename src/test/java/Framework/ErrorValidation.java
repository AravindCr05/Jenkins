package Framework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import POMclass.AddToCart;
import POMclass.CartPage;
import POMclass.CheckOutpage;
import POMclass.LoginPage;
import POMclass.PlaceOrder;
import Testcomponent.BaseClass;
import Testcomponent.RetryAnalyzer;

public class ErrorValidation extends BaseClass{

	@Test(groups= {"ErrorValidation"},retryAnalyzer=RetryAnalyzer.class)
	 public void LoginError() throws IOException, InterruptedException{
		landing.login("ramesharavind96@gmail.com", "Test123");
		Assert.assertEquals(landing.ErrorMessage(), "Incorrect email or password.");
	}
	@Test
	public void ProductError() {
		String ProductName = "IPHONE 13 PRO";
		AddToCart cart = landing.login("ramesharavind96@gmail.com", "Test@123");
		List<WebElement> Products = cart.AllProducts();
		CartPage cartpage =cart.Addingtocart(ProductName);
		cartpage.Cartpagenavigation();
		Boolean cart1 = cartpage.ProductCheck("IPHONE 13");
		Assert.assertFalse(cart1);
	}
	}
