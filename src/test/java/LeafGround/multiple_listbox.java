package LeafGround;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Validate Multiple list/Drop-down box
 */
public class multiple_listbox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/bharadwaj.viswanatha/Desktop/Multipledropdown.html");
		Thread.sleep(2000);
		WebElement Course = driver.findElement(By.id("multiple-select"));
		Select s = new Select(Course);
		s.selectByIndex(1);
		Thread.sleep(2000);
		s.selectByValue("7");
		Thread.sleep(2000);
		s.selectByVisibleText("Books");
		Thread.sleep(2000);

		List<WebElement> Allopt = s.getOptions();// Get all the option present in the list
		int Count = Allopt.size();
		for (int i = 0; i < Count; i++) {
			String Text = Allopt.get(i).getText();
			System.out.println(Text);
		}
		System.out.println("=====");
		String Firstselect = s.getFirstSelectedOption().getText();// Get the first option
		System.out.println(Firstselect);
		System.out.println("=====");

		List<WebElement> Selectedoption = s.getAllSelectedOptions();// Get the selected Option in the list
		int Selectedcount = Selectedoption.size();
		for (int i = 0; i < Selectedcount; i++) {
			String SelectedText = Selectedoption.get(i).getText();
			System.out.println(SelectedText);
		}
		System.out.println("======");
		String Wraptext = s.getWrappedElement().getText();// Get Wrapped
		System.out.println(Wraptext);

		driver.close();
	}

}
