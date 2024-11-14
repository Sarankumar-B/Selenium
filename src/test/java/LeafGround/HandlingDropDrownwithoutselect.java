package LeafGround;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDrownwithoutselect {
	@FindBy(xpath="//button[contains(.,'Login')]")
	private static WebElement Loginbutton;


	@FindBy(xpath="//a/span[contains(.,'Admin')]")
	private static WebElement AdminMenu;

	@FindBy(xpath="//div/label[contains(.,'User Role')]//parent::"
			+"div//following-sibling::div//div[@class='oxd-select-text oxd-select-text--active']")
	private static WebElement userrole;

	public static void main(String[] args) throws InterruptedException {
		String data=null;


		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		Loginbutton.click();

		AdminMenu.click();
		userrole.click();

		List<WebElement> Options = driver.findElements(By.xpath("//div[@role='listbox']//span"));


		for(WebElement alloptions:Options) {
			data = alloptions.getText();
			System.out.println(data);

		}
		System.out.println(data);
		driver.quit();
	}

}
