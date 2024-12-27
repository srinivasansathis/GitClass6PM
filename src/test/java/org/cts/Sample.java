package org.cts;

import java.io.IOException;

import org.hotel.AdactinLoginPage;
import org.hotel.PersonalDetails;
import org.hotel.SearchHotel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mvn.BaseClass;
import org.openqa.selenium.WebElement;

public class Sample extends BaseClass {

	@BeforeClass
	public static void beforeClass() {
		browserLaunch();
		loadUrl("https://adactinhotelapp.com/");
		windowMaxmize();
		System.out.println("Browser Launch");
	}

	@AfterClass
	public static void afterClass() {
		quitBrowser();
		System.out.println("Quiting Browser");
	}

	@Before
	public void Before() {
		dateAndTime();
		System.out.println("Start Time:");
	}

	@After
	public void After() {
		dateAndTime();
		System.out.println("End Time:");
	}

	@Test
	public void test1() throws IOException {
		AdactinLoginPage hotel = new AdactinLoginPage();
		WebElement userName = hotel.getUserName();
		type(userName, excelRead("Login", 1, 0));

		WebElement passWord = hotel.getPassWord();
		type(passWord, excelRead("Login", 1, 1));

		WebElement logIn = hotel.getLogIn();
		btnClick(logIn);
		System.out.println("Adactin Login Page");

	}

	@Test
	public void test2() throws IOException {
		SearchHotel search = new SearchHotel();
		WebElement loc = search.getLoc();
		selectValue(loc, excelRead("SearchHotel", 3, 0));

		WebElement room = search.getRoom();
		selectValue(room, excelRead("SearchHotel", 3, 3));

		WebElement adult = search.getAdult();
		selectValue(adult, excelRead("SearchHotel", 3, 4));

		WebElement submit = search.getSubmit();
		btnClick(submit);

		WebElement radioBtn = search.getRadioBtn();
		btnClick(radioBtn);

		WebElement cont = search.getCont();
		btnClick(cont);
		System.out.println("Search Hotel");

	}

	@Test
	public void test3() throws IOException {

		PersonalDetails data = new PersonalDetails();
		WebElement firstName = data.getFirstName();
		type(firstName, excelRead("PersonalDetails", 1, 0));

		WebElement lastName = data.getLastName();
		type(lastName, excelRead("PersonalDetails", 1, 1));

		WebElement address = data.getAddress();
		type(address, excelRead("PersonalDetails", 1, 2));

		WebElement credit = data.getCredit();
		type(credit, excelRead("PersonalDetails", 1, 3));

		WebElement cardType = data.getCardType();
		selectVisibleText(cardType, excelRead("PersonalDetails", 1, 4));

		WebElement expMonth = data.getExpMonth();
		selectVisibleText(expMonth, excelRead("PersonalDetails", 1, 5));

		WebElement expYear = data.getExpYear();
		selectVisibleText(expYear, excelRead("PersonalDetails", 1, 6));

		WebElement cvv = data.getCvv();
		type(cvv, excelRead("PersonalDetails", 1, 7));

		WebElement book = data.getBook();
		btnClick(book);

		WebElement text = data.getText();
		String attribute = attribute(text);
		System.out.println("Order Id:" + attribute);
		System.out.println("Personal Details");

	}

}
