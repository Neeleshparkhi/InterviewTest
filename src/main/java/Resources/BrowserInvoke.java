package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;






public class BrowserInvoke {

	public WebDriver driver; //given as public so that driver can be accessible from outside
	public WebDriver initalizeDriver() throws IOException
	{
		
		Properties prop= new Properties();
		FileInputStream fis = new FileInputStream("D:\\nShights_Neelesh\\Neelesh\\Automation\\All Selenium Projects\\InterviewTest\\src\\main\\java\\Resources\\base.properties");
		prop.load(fis);
		
		String BrowserName = prop.getProperty("browser");
		System.out.println(BrowserName);
		
		if(BrowserName.equals("chrome")) //if you are getting value from the properties file the you have to write "." on the place of "="
		{
			System.setProperty("WebDriver.driver.chrome", "C:\\Selenium Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(BrowserName.equals("firefox"))
		{
			System.setProperty("WebDriver.driver.gecko", "C:\\Selenium Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(BrowserName.equals("IE"))
		{
			System.setProperty("WebDriver.driver.IE", "C:\\Selenium Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//return to the driver
		return driver;
	}
	
	
}
