package LeafGround;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
/*
 * Handling Mouse Actions on the web page
 */
public class ActionClass {

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();

		
		driver.get("https://letcode.in/dropable");
		WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		WebElement Moveover = driver.findElement(By.xpath("//div/a[.='Courses']"));
		Actions a= new Actions(driver);
		a.dragAndDrop(from, to).build().perform();
		//Thread.sleep(3000);
		a.moveToElement(Moveover).build().perform();
		//Thread.sleep(3000);		
		a.clickAndHold(to).build().perform();
		//a.contextClick(to).build().perform();
		//a.doubleClick(to).build().perform();
		//test
		//testtodaynow
	

	}
}
