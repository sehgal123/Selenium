package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SpiceNewAccount {
	
	@FindBys(@FindBy(css="#li_myaccount>a"))
	private List<WebElement> myAccount;
	public List<WebElement> getMyAccount()
	{
		return myAccount;
	}
	
	@FindBys(@FindBy(xpath="//a[text()=' Login']"))
	private List<WebElement> login;
	public List<WebElement> getLogin()
	{
		return login;
	}
	
	@FindBy(xpath="//*[text()='Blog     '] ")
	private WebElement blog;
	public WebElement getBlog()
	{
		return blog;
	}
	
	@FindBy(css=".input-group")
	private WebElement inputGroup;
	public WebElement getInputGroup()
	{
		return inputGroup;
	}

}
