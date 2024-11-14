package LeafGround;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		//driver.switchTo().parentFrame();
		List<WebElement> countofframe = driver.findElements(By.tagName("iframe"));
		int count = countofframe.size();
		System.out.println("Total no of frames present in the webpages are:" + count);
		driver.quit();
	}

}