package LeafGround;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Robot_Class {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		Robot r=new Robot();
		Actions action=new Actions(driver);
		WebElement name = driver.findElement(By.xpath("//div/input[@type='text']"));
		WebElement yourself= driver.findElement(By.xpath("//h5[contains(.,'yourself')]//following::div/textarea"));


		action.sendKeys(name, "Myself Bharadwaj").build().perform();
		Thread.sleep(3000);
	
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_C);
		//Thread.sleep(3000);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		

		yourself.click();
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		//Thread.sleep(3000);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);

		driver.quit();

	}

}
