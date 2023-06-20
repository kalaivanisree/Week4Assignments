package week4assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindTabsOpened {

	public static void main(String[] args) {
	
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());		
		
		for (String wh : windowHandles) {
			System.out.println(wh);
		}
		
		List<String> winhand=new ArrayList<String>(windowHandles);		
		//driver.switchTo().window(winhand.get(1));
		System.out.println(winhand.size());
		

	}

}
