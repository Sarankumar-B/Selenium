package LeafGround;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFiles {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/file.xhtml;jsessionid=node010nx464jtc8vzxsmrg4fp0yu9138.node0");
		WebElement upload = driver.findElement(By.id("j_idt88:j_idt89_input"));
		File f = new File("./excel/Description.docx");
		String uploadfilepath = f.getAbsolutePath();
		upload.sendKeys(uploadfilepath);

		WebElement adupload = driver.findElement(By.id("j_idt97:j_idt98_input"));
		File f1 = new File("./excel/B image.jpg");

	}

}
