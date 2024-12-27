package org.hotel;

import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AdactinLoginPage extends BaseClass {
	public AdactinLoginPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBys({@FindBy(id = "username"),@FindBy(xpath = "//input[@name='username']")})
	private WebElement userName;
	
	@FindBys({@FindBy(id = "password"),@FindBy(xpath = "//input[@type='password']")})
	private WebElement passWord;
	
	@CacheLookup
	@FindBys({@FindBy(name = "login"),@FindBy(xpath = "//input[@value='Login']")})
	private WebElement logIn;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLogIn() {
		return logIn;
	}
	

}
