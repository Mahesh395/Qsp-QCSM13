package demo.actiTimeGenericUtils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import demo.actiTimePOM.HomePage;
import demo.actiTimePOM.LoginPage;

public class BaseClass
{
	WebDriver driver = null;
	PropertyUtils pUtils = new PropertyUtils();
	//String filepath = "./src/test/resources/actiTImePropertyFile.properties";

	@BeforeSuite
	public void configBS() {
		// database connection
	}

	@BeforeTest
	public void configBT() {
		// parallel testing codes
	}

	@BeforeClass
	public void configBC() 
	{
		// OPEN THE BROWSER
		//ProjectThreadSleep.sleepInseconds(5);
		String browserName = pUtils.getPropertyData(ActiTimeConstants.PROPFILE_PATH, ActiTimeConstants.BROWSER_NAME);
		//System.out.println(browserName);
		//String url = pUtils.getPropertyData(ActiTimeConstants.PROPFILE_PATH, ActiTimeConstants.MAINURL);

		if ("chrome".equals(pUtils.getPropertyData(ActiTimeConstants.PROPFILE_PATH, ActiTimeConstants.BROWSER_NAME))) 
		{
			System.setProperty(ActiTimeConstants.CHROME_KEY,ActiTimeConstants.CHROME_PATH);
			driver = new ChromeDriver();
		} 
		else if(browserName.equals("firefox")) 
		{
			System.setProperty(ActiTimeConstants.FIREFOX_KEY, ActiTimeConstants.FIREFOX_PATH);
			driver = new FirefoxDriver();
		} else 
		{
			throw new SessionNotCreatedException("browser is not compatible");
		}
		driver.manage().window().maximize();
		driver.get(pUtils.getPropertyData(ActiTimeConstants.PROPFILE_PATH, ActiTimeConstants.MAINURL));
	}

	@BeforeMethod
	public void configBM() {
		//ProjectThreadSleep.sleepInseconds(5);
		driver.manage().timeouts().implicitlyWait(ActiTimeConstants.IMP_TIME,TimeUnit.SECONDS);
		LoginPage loginPage = new LoginPage(driver);
		String username = pUtils.getPropertyData(ActiTimeConstants.PROPFILE_PATH,ActiTimeConstants.UN_KEY);
		String password = pUtils.getPropertyData(ActiTimeConstants.PROPFILE_PATH,ActiTimeConstants.PWD_KEY);
		loginPage.login(username, password);
	}

	@AfterMethod(alwaysRun = true)
	public void configAm(ITestResult result) 
	{
		String testCaseName = result.getName();
		int status = result.getStatus();
		if (status == result.FAILURE) 
		{
			 String filepath = GetScreenshot.getImage(driver, testCaseName);
			 System.out.println(filepath);
		}
		HomePage homePage = new HomePage(driver);
		homePage.logout();

	}

	@AfterClass
	public void configAC() {
		// close the browser
		driver.quit();

	}

	@AfterTest
	public void configAT() {
		// close all the parallel connection
	}

	@AfterSuite
	public void configAS() {
		// close database connection
	}

}
