package LeafGround;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascriptexecutor extends TakeascreenShot{
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.impigertechnologies.com/");
		WebElement Ourpatners = driver.findElement(By.xpath("//div/span[contains(.,'Our Partners')]"));
		WebElement Recognitions = driver.findElement(By.xpath("//div/span[.='Recognitions']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Ourpatners);
		Thread.sleep(2000);
		String Title =(String) js.executeScript("return document.title");
		System.out.println(Title);
		js.executeScript("arguments[0].click();",Recognitions);
		Thread.sleep(2000);
		TakeascreenShot.screenshot();
		driver.quit();


	}

}
