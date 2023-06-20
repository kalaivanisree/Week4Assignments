package week4assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseWindowNotPrimary {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath(" //span[text()='Close Windows']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());		
		
		for (String wh : windowHandles) {
			System.out.println(wh);
		}
		
		List<String> winhand=new ArrayList<String>(windowHandles);		
		//driver.switchTo().window(winhand.get(1));
		System.out.println(winhand.size());
		for(int i=1;i<winhand.size();i++) 
		{ 
			driver.switchTo().window(winhand.get(i));
		 driver.close(); 
		 }
		 
		 
	

	}

}
