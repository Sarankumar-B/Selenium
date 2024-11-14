package LeafGround;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		Thread.sleep(2000);
		WebElement Simplealert = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]"));
		Simplealert.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);

		WebElement confirmalert = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]"));
		confirmalert.click();
		Thread.sleep(2000);
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		Thread.sleep(2000);

		WebElement promptalert = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]"));
		promptalert.click();
		Thread.sleep(2000);
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Hii all");
		Thread.sleep(2000);
		alert3.accept();
		Thread.sleep(2000);

		driver.close();
	}

}
