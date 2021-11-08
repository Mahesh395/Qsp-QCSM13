package demo.actiTimeGenericUtils;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshot 
{
	public static String getImage(WebDriver driver,String testCaseName)
	{
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		String filepath = "./errorshot/"+timeStamp+testCaseName+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(filepath);
		sourceFile.renameTo(destinationFile);
		return filepath;
	}
}
