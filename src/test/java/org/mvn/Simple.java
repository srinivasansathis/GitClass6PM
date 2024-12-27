package org.mvn;

import java.io.IOException;

import org.hotel.AdactinLoginPage;
import org.hotel.PersonalDetails;
import org.hotel.SearchHotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Simple {

	public static void main(String[] args) throws IOException, InterruptedException {

		BaseClass baseClass = new BaseClass();
		WebDriver driver = baseClass.browserLaunch();
		baseClass.loadUrl("https://adactinhotelapp.com/");
		baseClass.windowMaxmize();
		baseClass.implicitWait(30);
		
		AdactinLoginPage hotel=new AdactinLoginPage();
		WebElement userName = hotel.getUserName();
		baseClass.type(userName, baseClass.excelRead("Login", 1, 0));
		
		WebElement passWord = hotel.getPassWord();
		baseClass.type(passWord, baseClass.excelRead("Login", 1, 1));
		
		WebElement logIn = hotel.getLogIn();
		baseClass.btnClick(logIn);
		
		SearchHotel search=new SearchHotel();
		WebElement loc = search.getLoc();
		baseClass.selectValue(loc, baseClass.excelRead("SearchHotel", 3, 0));
		
		WebElement room = search.getRoom();
		baseClass.selectValue(room, baseClass.excelRead("SearchHotel", 3, 3));
		
		WebElement adult = search.getAdult();
		baseClass.selectValue(adult, baseClass.excelRead("SearchHotel", 3, 4));
		
		WebElement submit = search.getSubmit();
		baseClass.btnClick(submit);
		
		WebElement radioBtn = search.getRadioBtn();
		baseClass.btnClick(radioBtn);
		
		WebElement cont = search.getCont();
		baseClass.btnClick(cont);
		
		PersonalDetails data=new PersonalDetails();
		
		WebElement firstName = data.getFirstName();
		baseClass.type(firstName, baseClass.excelRead("PersonalDetails", 1, 0));
		
		WebElement lastName = data.getLastName();
		baseClass.type(lastName, baseClass.excelRead("PersonalDetails", 1, 1));
		
		WebElement address = data.getAddress();
		baseClass.type(address, baseClass.excelRead("PersonalDetails", 1, 2));
		
		WebElement credit = data.getCredit();
		baseClass.type(credit, baseClass.excelRead("PersonalDetails", 1, 3));

		WebElement cardType = data.getCardType();
		baseClass.selectVisibleText(cardType, baseClass.excelRead("PersonalDetails", 1, 4));
		
		WebElement expMonth = data.getExpMonth();
		baseClass.selectVisibleText(expMonth, baseClass.excelRead("PersonalDetails", 1, 5));
		
		WebElement expYear = data.getExpYear();
		baseClass.selectVisibleText(expYear, baseClass.excelRead("PersonalDetails", 1, 6));
		
		WebElement cvv = data.getCvv();
		baseClass.type(cvv, baseClass.excelRead("PersonalDetails", 1, 7));
		
		WebElement book = data.getBook();
		baseClass.btnClick(book);
		
		WebElement text = data.getText();
		String attribute = baseClass.attribute(text);
		System.out.println("Order Id:"+attribute);
		
		baseClass.quitBrowser();



	}

}
