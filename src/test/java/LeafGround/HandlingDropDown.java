package LeafGround;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * 
 */
public class HandlingDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/dropdowns");
		
		WebElement Fruit = driver.findElement(By.xpath("//select[@id='fruits']"));
		WebElement Language = driver.findElement(By.xpath("//select[@id='lang']"));
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		WebElement superhero = driver.findElement(By.xpath("//select[@id='superheros']"));
		List<WebElement> Langcount = driver.findElements(By.xpath("//select[@id='lang']/option"));

		int count = Langcount.size()-1;
		Select select1=new Select(Fruit);
		select1.selectByVisibleText("Apple");
		select1.selectByIndex(1);
		select1.selectByValue("4");
		List<WebElement> fruitname = select1.getOptions();
		for (WebElement name : fruitname) {
			System.out.println(name.getText());
		}

		
		

		Select select2=new Select(Language);
		Thread.sleep(3000);
		select2.selectByIndex(count);
		Thread.sleep(3000);
		List<WebElement> options = select2.getOptions();
		for (WebElement alloptions : options) {
			System.out.println(alloptions.getText());
		}
		System.out.println("----------");

		Select select3= new Select(country);
		select3.selectByValue("India");
		String selectedvalue = select3.getFirstSelectedOption().getText();
		System.out.println(selectedvalue);
		
		Select multiple=new Select(superhero);
		if(multiple.isMultiple()) {
			multiple.selectByIndex(0);
			multiple.selectByIndex(2);
			Thread.sleep(3000);
			multiple.deselectAll();
			Thread.sleep(3000);
		}
		

		driver.quit();

	}

}
