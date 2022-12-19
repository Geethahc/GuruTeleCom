package com.gurutelecom.pageobjects;

import com.gurutelecom.actiondriver.Action;
import com.gurutelecom.base.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;

public class HomePage extends BaseClass{
	
	Action action = new Action();
	@FindBy(xpath="//a[text()='Add Customer']")
	private WebElement AddCusLink;
	
	@FindBy(xpath="//a[text()='Guru99 telecom']")
	private WebElement telecomLogo;
	
	
	public HomePage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean validateLogo()
	{
		return action.isDisplayed(getdriver(), telecomLogo);
	}
	public String getHomePageTitle() {
		return getdriver().getTitle();
	}
	public boolean validateLinkNavigation() throws Throwable {
		return false;
		
	}
	public AddCustomerPage clickOnAddCustomer() throws Throwable
	{
		
		action.fluentWait(getdriver(), AddCusLink, 10);
		action.explicitWaitClickable(getdriver(),AddCusLink,10);
		action.click(getdriver(), AddCusLink);
		return new AddCustomerPage();
	}
	
}
