package LeafGround;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Draganddrop
 */
public class Draganddrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		WebElement from = driver.findElement(By.id("form:drag_content"));
		WebElement to = driver.findElement(By.id("form:drop_content"));

		Actions a = new Actions(driver);
		Thread.sleep(2000);
		a.dragAndDrop(from, to).build().perform();
		Thread.sleep(2000);

		driver.quit();
	}

}
