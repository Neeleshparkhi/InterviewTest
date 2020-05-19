package UserLogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.BrowserInvoke;

public class UserLogin extends BrowserInvoke{
	
	public WebDriver driver;
	
	@Test(priority=1)
	public void Login() throws IOException
	{
	
		driver=initalizeDriver();
		
		//loading Base properties file
		Properties Baseprop = new Properties();
		FileInputStream Basefis = new FileInputStream("D:\\nShights_Neelesh\\Neelesh\\Automation\\All Selenium Projects\\InterviewTest\\src\\main\\java\\Resources\\base.properties");
		Baseprop.load(Basefis);
		
		//Loading Locaters properties file
		Properties Loginprop = new Properties();
		FileInputStream Loginfis = new FileInputStream("D:\\nShights_Neelesh\\Neelesh\\Automation\\All Selenium Projects\\InterviewTest\\src\\main\\java\\Resources\\Loginlocater.properties");
		Loginprop.load(Loginfis);
		
		//invoking the URL
		driver.get(Baseprop.getProperty("URL"));
		
		//browser maximising and deleting all cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
				
		//click on signin button
		driver.findElement(By.xpath(Baseprop.getProperty("Signin"))).click();
		
		//Click on Login
		driver.findElement(By.xpath(Loginprop.getProperty("Login"))).click();
		driver.findElement(By.xpath(Loginprop.getProperty("Login"))).sendKeys(Baseprop.getProperty("UserName"));
		
		//Entering password
		driver.findElement(By.xpath(Loginprop.getProperty("Password"))).click();
		driver.findElement(By.xpath(Loginprop.getProperty("Password"))).sendKeys(Baseprop.getProperty("Password"));
		
		//Login into the portal
		driver.findElement(By.xpath(Loginprop.getProperty("SignIn"))).click();
		
	}
	
	@Test(priority=2)
	
	public void purchase() throws IOException, Exception
	{
		
		//Loading Locaters properties file
		Properties Loginprop = new Properties();
		FileInputStream Loginfis = new FileInputStream("D:\\nShights_Neelesh\\Neelesh\\Automation\\All Selenium Projects\\InterviewTest\\src\\main\\java\\Resources\\Loginlocater.properties");
		Loginprop.load(Loginfis);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(Loginprop.getProperty("Womenclick"))).click();
		Thread.sleep(5000);
		
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[1]")));

		//For page scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
				
		// This  will scroll down the page by  1000 pixel vertical		
		js.executeScript("window.scrollBy(0,1000)");
				
		
		//Mouse Movement to the product
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(10000);
		
		
		
		//Click on quick view
		driver.findElement(By.xpath("//*[text()='Quick view']")).click();
		Thread.sleep(5000);

		int num = driver.findElements(By.tagName("iframe")).size();
		//System.out.println(num);
		
		//Switch to the Window
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
		
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("2");
		
		//click on add to cart button
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(4000);
		
		driver.switchTo().defaultContent();
		
		String total = driver.findElement(By.xpath("//div[@class='layer_cart_cart col-xs-12 col-md-6']//div[3]")).getText();
		System.out.println(total);
		
		//click on proceed to checkout
		driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']")).click();
		Thread.sleep(5000);
		
		String Total = driver.findElement(By.className("cart_total_price")).getText();
		System.out.println(Total);
		
		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();
     	Thread.sleep(3000);
		
		driver.findElement(By.name("processAddress")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("uniform-cgv")).click();
		
		driver.findElement(By.name("processCarrier")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.className("cheque")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
		Thread.sleep(2000);
		
		String Order = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();
		System.out.println(Order);
		
	}
	
	@Test(priority=3)
	public void OrderHistory() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"footer\"]/div/section[5]/div/ul/li[1]/a")).click();
		Thread.sleep(3000);
		String FinalAmount = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[3]")).getText();
		System.out.println("Total price is:- " + FinalAmount);
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.quit();
	}

}
