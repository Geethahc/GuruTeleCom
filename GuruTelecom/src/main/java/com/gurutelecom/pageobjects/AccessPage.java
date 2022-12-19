package com.gurutelecom.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gurutelecom.base.BaseClass;

public class AccessPage extends BaseClass {
	
	@FindBy(xpath="//b[text()='Customer ID']/../..//td[2]/h3")
	private WebElement customerID;
	
	public AccessPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public int getCustomerId() {
		System.out.println("Customer ID  is -->" +customerID.getText());
		return Integer.parseInt(customerID.getText());
	}

}
