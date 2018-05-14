import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Screenshots_Example {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\geckodriver.exe"); //*Provide path of geckodriver on your system
		driver = new FirefoxDriver();
		driver.get("https://hdfcbank.com/");
		driver.manage().window().maximize();
		captureScreenshots("homepage");
		
		driver.findElement(By.linkText("Register")).click();
		captureScreenshots("register_page");
		
		

	}
	
	public static void captureScreenshots(String filename) throws IOException
	{
		TakesScreenshot objScreenshot = ((TakesScreenshot)driver);
		File objSrcFile =objScreenshot.getScreenshotAs(OutputType.FILE);
		
		File objDestFile = new File("F:\\Selenium\\Snapshots\\" + filename + ".jpg"); //* Provide any path on your system.
		
		FileUtils.copyFile(objSrcFile,objDestFile);
		
	}

}
