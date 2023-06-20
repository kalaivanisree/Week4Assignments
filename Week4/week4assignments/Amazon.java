package week4assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys( "oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(price);
		String rating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println(rating);
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
	     System.out.println(windowHandles.size());
	     for (String wh : windowHandles) {
			System.out.println(wh); 
		}
	     List<String> wind=new ArrayList<String>(windowHandles);
	     driver.switchTo().window(wind.get(1));
	     driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			File path=new File("./snap/amazon.png");
			FileUtils.copyFile(screenshotAs, path);
			driver.findElement(By.xpath("//span[@id='submit.add-to-cart']")).click();
			String subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
			System.out.println(subtotal);
			String i="";
			if(i.equals(subtotal))
			{
				System.out.println("Price is Correct");
			}
			else
				System.out.println("Price is Incorrect"); 
			Thread.sleep(4000);
			driver.close();
	}
  
}
