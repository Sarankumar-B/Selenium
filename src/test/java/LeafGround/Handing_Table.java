package LeafGround;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Handling_Tables
 */
public class Handing_Table {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/table");
		driver.manage().window().maximize();
		List<WebElement> Tablehead = driver.findElements(By.xpath("//table[@id='simpletable']//th"));
		for (WebElement head: Tablehead) {

			String text = head.getText();
			System.out.println(text);

		}
		WebElement click=driver.findElement(By.xpath("//tr/td[.='Raj']//following-sibling::td/input"));
		WebElement name = driver.findElement(By.xpath("//tr/td[.='Raj']"));
		if(name.isDisplayed()) {
			System.out.println("Clicked");
			Thread.sleep(3000);
			click.click();
			Thread.sleep(3000);
		}
		driver.quit();

		WebDriverManager.chromedriver().setup();

		WebDriver driver1=new ChromeDriver();
		driver1.get("https://letcode.in/advancedtable");

		List<WebElement> Tablerow = driver1.findElements(By.xpath("//table/tbody/tr"));
		int tablerowcount = Tablerow.size();
		System.out.println(tablerowcount);
		List<WebElement> Tabledata = driver1.findElements(By.xpath("//table/tbody/tr[1]/td"));
		int tabledatacount= Tabledata.size();
		System.out.println(tabledatacount);

		for(int i=1;i<=tablerowcount;i++) {//rowcount
			for(int j=1;j<=tabledatacount;j++){//coloumn count
				WebElement Table = driver1.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]"));
				Thread.sleep(1000);
				String tabledata = Table.getText();
				System.out.print(tabledata+" "); 
			}
			System.out.println();
		}
		driver1.quit();
	}

}
