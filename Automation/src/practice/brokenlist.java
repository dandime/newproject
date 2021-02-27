package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlist {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size());
		
		for(int i=0; i<links.size(); i++)
		{
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			
			URL abc=new URL(url);
			
			HttpURLConnection httpcon=(HttpURLConnection)abc.openConnection();
			httpcon.connect();
			
			int rescode = httpcon.getResponseCode();
			
			if(rescode>=400)
			{
				System.out.println(url+"-"+"is broken link");
			}
			else
			{
				System.out.println(url+"-"+"is valid link");
			}
				
			
		}

	}

}
