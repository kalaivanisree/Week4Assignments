package week4assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) {
		 ChromeDriver driver=new ChromeDriver();
		   driver.get("https://leafground.com/drag.xhtml;jsessionid=node0zsycak31y1lb4d76b20wvtx1311979.node0");
		   driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement dragbox = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
			Actions act=new Actions(driver);
			act.dragAndDropBy(dragbox, 350, 400).perform();
			WebElement source = driver.findElement((By.xpath("//p[text()='Drag to target']")));
			WebElement destination = driver.findElement(By.xpath("//p[text()='Drop here']"));
			act.dragAndDrop(source, destination).perform();
			
			
             
	}

}
