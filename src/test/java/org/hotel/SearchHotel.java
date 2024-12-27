package org.hotel;

import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindAll({@FindBy(name = "location"),@FindBy(id = "location")})
	private WebElement loc;
	
	@FindAll({@FindBy(id = "room_nos"),@FindBy(id = "room_nos")})
	private WebElement room;
	
	@FindAll({@FindBy(name = "adult_room"),@FindBy(xpath = "//option[text()='- Select Adults per Room -']")})
	private WebElement adult;
	
	@CacheLookup
	@FindAll({@FindBy(name = "Submit"),@FindBy(id = "Submit")})
	private WebElement submit;
	
	@FindAll({@FindBy(id = "radiobutton_2"),@FindBy(name = "radiobutton_2")})
	private WebElement radioBtn;

	@CacheLookup
    @FindAll({@FindBy(name = "continue"),@FindBy(xpath = "//input[@value='Continue']")})
    private WebElement cont;

	public WebElement getLoc() {
		return loc;
	}

	public WebElement getRoom() {
		return room;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getRadioBtn() {
		return radioBtn;
	}

	public WebElement getCont() {
		return cont;
	}
	
	

}
