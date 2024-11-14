package LeafGround;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeascreenShot {
	static WebDriver driver;
	public static void screenshot() {
		Date currentdate=new Date();
		String screenshotfilename=currentdate.toString().replace(" ","-").replace(":", "-");



		File desgination=new File("./Screenshots/"+screenshotfilename+".png");
		File Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Screenshot,desgination);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
