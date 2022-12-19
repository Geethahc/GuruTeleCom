package com.gurutelecom.pageobjects;

import java.math.BigInteger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gurutelecom.actiondriver.Action;
import com.gurutelecom.base.BaseClass;

public class AddCustomerPage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(xpath="//input[@id='done' and @type='radio']")
	private WebElement flagBGCdone;
	@FindBy(xpath="//input[@id='pending' and @type='radio']")
	private WebElement flagBGCpending;
	@FindBy(xpath="//input[@id='fname' and @type='text']")
	private WebElement firstName;
	@FindBy(xpath="//input[@id='lname' and @type='text']")
	private WebElement lastName;
	@FindBy(xpath="//input[@id='email' and @type='email']")
	private WebElement email;
	@FindBy(xpath="//textarea[@id='message']")
	private WebElement address;
	@FindBy(xpath="//input[@id='telephoneno']")
	private WebElement telePhoneNum;
	@FindBy(xpath="//input[@type='submit' and @value='Submit']")
	private WebElement submitBtn;
	public 	AddCustomerPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void addCustomer(String strBgc, String strFirstName, String strLastName, String strEmail, String strAddress, String strMobileNum ) {
		
		if(strBgc.equalsIgnoreCase("Done"))
		action.click(getdriver(), flagBGCdone);	
		else if (strBgc.equalsIgnoreCase("Pending"))
		action.click(getdriver(), flagBGCpending);	
		
		action.type(firstName, strFirstName);
		action.type(lastName, strLastName);
		action.type(email, strEmail);
		action.type(address, strAddress);
		action.type(telePhoneNum, (strMobileNum));
	}
	
	public AccessPage validateCustomerCreation() throws Throwable{
		submitBtn.click();
		return new AccessPage();
		
	}
	
	

}
