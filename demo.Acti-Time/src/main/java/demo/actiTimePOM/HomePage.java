package demo.actiTimePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import demo.actiTimeGenericUtils.WebActionUtilities;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	public void logout()
	{
		logout.click();/*
						 * WebActionUtilities webActions = new WebActionUtilities(driver);
						 * webActions.clickOnElement(logout);
						 */
	}
}
