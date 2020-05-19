package AccountCreation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.BrowserInvoke;



public class CreateAccount extends BrowserInvoke
{
	
	public WebDriver driver;
	
	@Test
	public void basepagenavigation() throws IOException 
	{
		
		driver=initalizeDriver();
		
		//loading Base properties file
		Properties Baseprop = new Properties();
		FileInputStream Basefis = new FileInputStream("D:\\nShights_Neelesh\\Neelesh\\Automation\\All Selenium Projects\\InterviewTest\\src\\main\\java\\Resources\\base.properties");
		Baseprop.load(Basefis);
		
		//Loading Locaters properties file
		Properties Locaterprop = new Properties();
		FileInputStream Locaterfis = new FileInputStream("D:\\nShights_Neelesh\\Neelesh\\Automation\\All Selenium Projects\\InterviewTest\\src\\main\\java\\Resources\\Registrationlocaters.properties");
		Locaterprop.load(Locaterfis);
		
		Properties Userprop = new Properties();
		FileInputStream Userfis = new FileInputStream("D:\\nShights_Neelesh\\Neelesh\\Automation\\All Selenium Projects\\InterviewTest\\src\\main\\java\\Resources\\userdetails.properties");
		Userprop.load(Userfis);
		
		//initiating the website
		driver.get(Baseprop.getProperty("URL"));
		
		//browser maximising and deleting all cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//click on signin button
		driver.findElement(By.xpath(Baseprop.getProperty("Signin"))).click();
		
		//Click on Email Address Box
		driver.findElement(By.xpath(Locaterprop.getProperty("Emailaddress"))).click();
		
		//Entering the email address
		driver.findElement(By.xpath(Locaterprop.getProperty("Emailaddress"))).sendKeys(Userprop.getProperty("Emailid"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//Click on Create An account
		driver.findElement(By.xpath(Locaterprop.getProperty("CreatAnAccount"))).click();
		
		//Clicking on Radio button
		WebElement Gender = driver.findElement(By.id(Locaterprop.getProperty("Gender")));
		Gender.click();
		
		//click on FistName
		driver.findElement(By.xpath(Locaterprop.getProperty("FirstName"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("FirstName"))).sendKeys(Userprop.getProperty("FirstName"));
		
		//click on LastName
		driver.findElement(By.xpath(Locaterprop.getProperty("LastName"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("LastName"))).sendKeys(Userprop.getProperty("LastName"));
		
		//Entering Password
		driver.findElement(By.xpath(Locaterprop.getProperty("Password"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("Password"))).sendKeys(Userprop.getProperty("Password"));
		
		//Selecting date fo birth
		//creating select method for selecting the drop down
		Select day = new Select(driver.findElement(By.xpath(Locaterprop.getProperty("Days"))));
		day.selectByValue(Userprop.getProperty("Day"));
		
		//Selecting months
		Select month = new Select(driver.findElement(By.xpath(Locaterprop.getProperty("Months"))));
		
		month.selectByValue(Userprop.getProperty("Month"));
		
		//Select Years
		Select year = new Select(driver.findElement(By.xpath(Locaterprop.getProperty("Years"))));
		year.selectByValue(Userprop.getProperty("Year"));
		
		//Select the check box
		driver.findElement(By.xpath(Locaterprop.getProperty("Signupforournewsletter"))).click();
		
		//Entering Your Company details
		driver.findElement(By.xpath(Locaterprop.getProperty("Company"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("Company"))).sendKeys(Userprop.getProperty("Company"));
		
		//Entering your Adders details
		driver.findElement(By.xpath(Locaterprop.getProperty("Address"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("Address"))).sendKeys(Userprop.getProperty("Address"));
		
		//Entering City details
		driver.findElement(By.xpath(Locaterprop.getProperty("City"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("City"))).sendKeys(Userprop.getProperty("City"));
		
		//Selecting the state
		Select state = new Select(driver.findElement(By.xpath(Locaterprop.getProperty("State"))));
		state.selectByVisibleText(Userprop.getProperty("State"));
		
		//Enterin Zip code
		driver.findElement(By.xpath(Locaterprop.getProperty("ZipCode"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("ZipCode"))).sendKeys(Userprop.getProperty("ZipCode"));
		
		//Enter country details
		Select Country = new Select (driver.findElement(By.xpath(Locaterprop.getProperty("Country"))));
		Country.selectByVisibleText(Userprop.getProperty("Country"));
		
		//Addition information entering
		driver.findElement(By.xpath(Locaterprop.getProperty("AdditionaInfo"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("AdditionaInfo"))).sendKeys(Userprop.getProperty("AdditionaInfo"));
		
		//Entering home phone details
		driver.findElement(By.xpath(Locaterprop.getProperty("HomePhone"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("HomePhone"))).sendKeys(Userprop.getProperty("HomePhone"));
		
		//Entering mobile number
		driver.findElement(By.xpath(Locaterprop.getProperty("MobileNo"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("MobileNo"))).sendKeys(Userprop.getProperty("MobileNo"));
		
		//Address Alis
		driver.findElement(By.xpath(Locaterprop.getProperty("AddressAlis"))).click();
		driver.findElement(By.xpath(Locaterprop.getProperty("AddressAlis"))).sendKeys(Userprop.getProperty("AddressAlis"));
		
		//Click on register
		driver.findElement(By.xpath(Locaterprop.getProperty("Register"))).click();
		
		
	}
	
	

}
