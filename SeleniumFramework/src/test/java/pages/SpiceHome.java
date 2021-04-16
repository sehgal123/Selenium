package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SpiceHome extends PageBase {
	
	@FindBys(@FindBy(css="#li_myaccount>a"))
	private List<WebElement> myAccount;
	public List<WebElement> getMyAccount()
	{
		return myAccount;
	}
	
	@FindBy(xpath="//a[text()='Login / Signup']")
	private WebElement loginLink;
	public WebElement getLoginLink()
	{
		return loginLink;
	}
	
	@FindBy(xpath="//a[text()='SpiceClub Members']")
	private WebElement spiceMembersLink;
	public WebElement getSpiceMembersLink()
	{
		return spiceMembersLink;
	}
	
	@FindBy(xpath="//a[text()='Sign up']")
	private WebElement signUpLink;
	public WebElement getSighUpLink()
	{
		return signUpLink;
	}
	
	//Methods
	public void NavigateToSignup(){
		Actions action = new Actions(driver);
		action.moveToElement(getLoginLink()).build().perform();
		action.moveToElement(getSpiceMembersLink()).build().perform();
		getSighUpLink().click();
	}
}
