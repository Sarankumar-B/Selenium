package LeafGround;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Autoit {


	public static void main(String[] args) throws IOException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/file.xhtml");
		WebElement imageupload = driver.findElement(By.xpath("(//span[contains(.,'Choose')])[1]"));
		imageupload.click();
		Runtime.getRuntime().exec("C:\\Users\\bharadwaj.viswanatha\\Desktop\\Fileuploadautoit.exe");
		
		WebElement uploadbutton = driver.findElement(By.xpath("//span[.='Upload']"));

		}

	}

