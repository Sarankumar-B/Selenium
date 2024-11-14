package SeleniumLearning;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Email {


	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();

		driver.get("https://login.microsoftonline.com/common/oauth2/authorize?client_id=00000002-0000-0ff1-ce00-000000000000&redirect_uri=https%3a%2f%2foutlook.office.com%2fowa%2f&resource=00000002-0000-0ff1-ce00-000000000000&response_mode=form_post&response_type=code+id_token&scope=openid&msafed=1&msaredir=1&client-request-id=dae54ea5-9e61-035b-3aef-1c5cc23263ef&protectedtoken=true&claims=%7b%22id_token%22%3a%7b%22xms_cc%22%3a%7b%22values%22%3a%5b%22CP1%22%5d%7d%7d%7d&domain_hint=xuvi.com&nonce=638320097424237077.733331ae-dcf7-4701-bb86-7a695b233ff7&state=DYuxDoIwFABb_Re3yqOFPjoQB41hwAVNNGx9pU0gEgwQjH9vL7nbjjPG9tFdlEMMQ60KJQEMZjKTCgHxiCqSWi86F1BkCKkgKrRAq01OUqkQkMf3kkxfm5yW1a6-TA-z7_rZu_UxlbZqwFU3Xf_M1r2ahaSZ69GM7fge2ns-kISNntcPnYs_");
		driver.manage().window().maximize();

		//email id
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mohan.perumal@xuvi.com");

		WebElement nxt = driver.findElement(By.xpath("//input[@type='submit']"));
		nxt.click(); 

		//password
		WebElement pwd = driver.findElement(By.id("i0118"));
		pwd.sendKeys("Linkedmo@123"); 

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-report-event='Signin_Submit']"))).click();

		//confirm for next step
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		
		
		boolean refresh = true;

		do {

			driver.navigate().refresh();

			WebElement filter= driver.findElement(By.xpath("//div[@id='mailListFilterMenu']//span[@role='presentation']"));
			filter.click();
			WebElement unreadfilter=driver.findElement(By.xpath("//span[.='Unread']"));
			unreadfilter.click();
			WebElement sub = driver.findElement(By.xpath("//div[@class='IjzWp XG5Jd gy2aJ Ejrkd']/span"));
			
			try {

			
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				String subjecttext = sub.getText();
				if(subjecttext.contains("OTP")) {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					sub.click();
					refresh=false;
					String txt = driver.findElement(By.xpath("//div[@visiblity='visible']")).getText();
					Pattern pattern = Pattern.compile("Your OTP is (.*?),");
					Matcher matcher = pattern.matcher(txt);
					if (matcher.find()) {
						System.out.println(matcher.group(1));
					}
				
				}
			}
			catch (StaleElementReferenceException e ) {
			
			}catch (NoSuchElementException n) {
				
			}
			
			}while(refresh);

			System.out.println("The End");
		}
	}
