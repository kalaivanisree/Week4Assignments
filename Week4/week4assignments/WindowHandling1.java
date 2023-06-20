package week4assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling1 {

	
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
	
     public static void main(String[] args) {
	
	  ChromeDriver driver=new ChromeDriver();
	   driver.get("http://leaftaps.com/opentaps/control/login");
	   driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
     driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
     driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
     driver.findElement(By.xpath("//div[@id='label']/a")).click();
     driver.findElement(By.linkText("Contacts")).click();
     driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
     String windowHandle = driver.getWindowHandle();
     driver.findElement(By.xpath("(//a)[35]/img")).click();
     
     Set<String> windowHandles = driver.getWindowHandles();
     System.out.println(windowHandles.size());
     for (String wh : windowHandles) {
		System.out.println(wh); 
	}
     List<String> wind=new ArrayList<String>(windowHandles);
     driver.switchTo().window(wind.get(1));
     driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a")).click();
		driver.switchTo().window(windowHandle);
		
		
		driver.findElement(By.xpath("(//a)[36]/img")).click();
		Set<String> windHandles = driver.getWindowHandles();
	     System.out.println(windHandles.size());
	     for (String whs : windHandles) {
			System.out.println(whs); 
		}
	     List<String> winds=new ArrayList<String>(windHandles);
	     driver.switchTo().window(winds.get(1));
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(windowHandle);
		driver.findElement(By.xpath("(//a)[37]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
     
	}

}
