package week4assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement brand = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
        Actions act=new Actions(driver);
        act.moveToElement(brand).perform();
        driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
        WebElement loreal = driver.findElement(By.xpath("(//div[@class='css-150nd8c']/a)[1]"));
        Actions act1=new Actions(driver);
        act1.moveToElement(loreal).click().perform();
      String title = driver.getTitle();
        System.out.println(title);
      driver.findElement(By.xpath("//span[@class='sort-name']")).click();
      driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
     driver.findElement(By.xpath("//span[text()='Category']")).click();
     driver.findElement(By.xpath("//span[text()='Hair']")).click();
     driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
     driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
     driver.findElement(By.xpath("//span[text()='Concern']")).click();
     driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[12]")).click();
     driver.findElement(By.xpath("//div[@class='css-43m2vm']/img")).click();
     Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());		
		
		for (String wh : windowHandles) {
			System.out.println(wh);
		}
		
		List<String> winhand=new ArrayList<String>(windowHandles);		
		driver.switchTo().window(winhand.get(1));
		driver.findElement(By.xpath("(//span[@class=' css-d3w64v'])[1]")).click();
		String price = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
		System.out.println(price);
		driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
		driver.findElement(By.xpath("(//*[name()='svg'])[7]")).click();
		driver.switchTo().frame(0);
		String total1 = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		System.out.println(total1);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("(//img[@class='css-16z7tzi ek8d9s80'])[2]")).click();
		String total2 = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']")).getText();
		System.out.println(total2); 
		if(total1.equals(total2)) {
			System.out.println("Same Total");
		}else
		System.out.println("DifferentTotal");
			driver.quit();
		}
	}
        

