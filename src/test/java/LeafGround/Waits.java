package LeafGround;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Handling static and Dynamic wait
 */
public class Waits {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/waits.xhtml");
		WebElement visible = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']"));
		//	Thread.sleep(3000);

		visible.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement Textchange = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt98']"));
		Textchange.click();

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement Text = driver.findElement(By.xpath("//button/span[contains(.,'notice?')]"));
		wait.until(ExpectedConditions.visibilityOf(Text));

		String ChangedText = Text.getText();
		System.out.println(ChangedText);


		WebElement InvisibleButton = driver.findElement(By.xpath("//div/h5[contains(.,'Invisibility')]//following-sibling::div//button/span[.='Click']"));
		WebElement tobeHidetext = driver.findElement(By.xpath("//button/span[contains(.,'about to hide')]"));
		InvisibleButton.click();
		Wait <WebDriver>Fluentwait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10)).withMessage("This is fluent wait")
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		
		Fluentwait.until(ExpectedConditions.invisibilityOf(tobeHidetext));
	

		driver.quit();


	}

}
