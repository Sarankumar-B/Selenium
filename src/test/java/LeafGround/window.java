package LeafGround;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Handling Windows by using Get window handle and Get window handles
 */
public class window {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		String Firstwindow = driver.getWindowHandle();
		driver.findElement(By.id("j_idt88:new")).click();

		Set<String> Newwindow = driver.getWindowHandles();
		for (String newwindow : Newwindow) {
			driver.switchTo().window(newwindow);

		}
		String ActualTitle = driver.getTitle();
		if (ActualTitle.contains("Dashboard")) {
			System.out.println("New window was opened----->Tc pass" + ActualTitle);
		} else {
			System.out.println("Try again" + ActualTitle);

		}
		driver.close();
		driver.switchTo().window(Firstwindow);
		String Checkurl = driver.getCurrentUrl();
		System.out.println(Checkurl);
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		int countwindow = driver.getWindowHandles().size();
		System.out.println("The number of windows are open" + countwindow);

		driver.findElement(By.id("j_idt88:j_idt91")).click();
		Set<String> close = driver.getWindowHandles();
		for (String closeall : close) {
			if (!closeall.equals(Firstwindow)) {
				driver.switchTo().window(closeall);
				driver.close();
			}
		}
		driver.switchTo().window(Firstwindow);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]")).click();



		WebElement Table = driver.findElement(By.className("card"));
		if (Table.isDisplayed()) {
			System.out.println("You are in table page");
		} else {
			System.out.println("Try again later");
		}

		driver.quit();

	}

}
