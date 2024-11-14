package LeafGround;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radiobutton_Example {
	static boolean ex = false;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.leafground.com/radio.xhtml;jsessionid=node01ke7fn8mh9k3910ujmkgbxcjb6284384.node0");
		driver.findElement(By.xpath("(//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default'])[9]"))
				.click();
		WebElement deselectradio = driver.findElement(
				By.xpath("(//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default'])[14]"));
		deselectradio.click();
		deselectradio.click();
		WebElement checkdefault1 = driver.findElement(
				By.xpath("(//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default'])[16]"));
		WebElement checkdefault2 = driver.findElement(
				By.xpath("(//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default'])[17]"));
		WebElement checkdefault3 = driver.findElement(By.xpath(
				"(//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default ui-state-active'])[4]"));
		WebElement checkdefault4 = driver.findElement(
				By.xpath("(//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default'])[18]"));
		if (checkdefault1.isSelected()) {
			String text1 = checkdefault1.getText();
			System.out.println(text1);

		} else if (checkdefault2.isSelected()) {
			String text2 = checkdefault2.getText();
			System.out.println(text2);
		} else if (checkdefault3.isSelected()) {
			String text3 = checkdefault3.getText();
			System.out.println(text3);
		} else if (checkdefault4.isSelected()) {
			String text4 = checkdefault4.getText();
			System.out.println(text4);
		}
		WebElement agee1 = driver.findElement(By.xpath("//*[@id='j_idt87:age']/div/div[1]/div/div[2]"));
		WebElement agee2 = driver.findElement(By.xpath("//*[@id='j_idt87:age']/div/div[2]/div/div[2]"));

		boolean print = agee2.isSelected();//
		System.out.println(print);// true
		boolean print2 = agee1.isSelected();// radio, check box,etc..
		System.out.println(print2);// false
		if (print == false) {// true===false
			agee2.click();
			System.out.println("21-40 was selected");
		} else if (print2 == false) {// false==false
			agee1.click();
			Thread.sleep(2000);
			System.out.println("1-20 was selected");
		}

		driver.close();
	}

}
