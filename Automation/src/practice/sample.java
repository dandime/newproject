package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class sample {

	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-notification");
		System.out.println("welcome");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("7517849715");
		
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("preeti@3031");
		
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		WebElement clos = driver.findElement(By.xpath("//i[@class='hu5pjgll m6k467ps sp_bWQHThPDKdk sx_21d0ed']"));
		
		if(clos.isDisplayed())
		{
			clos.click();
		}
	}

}
