package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import page.AddCustomerPage;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src/main/java/data/loginTestData.xlsx");
	String username = exlread.getCellData("Logininfo", "UserName", 2);
	String password = exlread.getCellData("Logininfo", "Password", 2);
	
	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String company = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlread.getCellData("AddContactInfo", "Email", 2);
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String state = exlread.getCellData("AddContactInfo", "State", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	
	
	
	@Test
	public void validUserShouldBeAbleToCreateCustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSignInButton();
		
		DashboardPage dashBoard = PageFactory.initElements(driver, DashboardPage.class);
		dashBoard.verifyDashBoardPage();
		dashBoard.clickCustomersButton();
		dashBoard.AddCustomersButton();
		
		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.verifyAddContactPage();
		addCustomer.enterFullname(fullName);
		addCustomer.selectCompany(company);
		addCustomer.enterEmail(email);
		addCustomer.enterPhoneNumber(phone);
		addCustomer.enterAddress(address);
		addCustomer.enterCity(city);
		addCustomer.enterState(state);
		addCustomer.enterZip(zip);
		addCustomer.enterCountry(country);
		addCustomer.saveButton();
		
		addCustomer.accountSummaryPage();
		dashBoard.listCustomersButton();
		addCustomer.verifyEnteredNameAndDelete();
		
	//	BrowserFactory.tearDown();
	}
}
