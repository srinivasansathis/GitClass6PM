package org.hotel;

import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetails extends BaseClass {
	public PersonalDetails() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBys({@FindBy(name = "first_name"),@FindBy(xpath = "(//input[@type='text'])[11]")})
	private WebElement firstName;
	
	@FindBys({@FindBy(name = "last_name"),@FindBy(xpath = "(//input[@type='text'])[12]")})
	private WebElement lastName;
	
	@FindAll({@FindBy(className = "txtarea"),@FindBy(name = "address")})
	private WebElement address;
	
	@FindAll({@FindBy(name = "cc_num"),@FindBy(id = "cc_num")})
	private WebElement credit;
	
	@FindAll({@FindBy(name = "cc_type"),@FindBy(id = "cc_type")})
	private WebElement cardType;
	
	@FindAll({@FindBy(id = "cc_exp_month"),@FindBy(id = "cc_exp_month")})
	private WebElement expMonth;
	
	@FindAll({@FindBy(name = "cc_exp_year"),@FindBy(id = "cc_exp_year")})
	private WebElement expYear;
	
	@FindAll({@FindBy(name = "cc_cvv"),@FindBy(xpath = "(//input[@type='text'])[14]")})
	private WebElement cvv;
	
	@CacheLookup
	@FindAll({@FindBy(xpath = "//input[@value='Book Now']"),@FindBy(id = "book_now")})
	private WebElement book;
	
	@FindAll({@FindBy(name = "order_no"),@FindBy(id = "order_no")})
	private WebElement text;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCredit() {
		return credit;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpYear() {
		return expYear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBook() {
		return book;
	}

	public WebElement getText() {
		return text;
	}
	

}
