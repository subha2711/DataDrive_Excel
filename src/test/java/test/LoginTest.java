package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src/main/java/data/loginTestData.xlsx");
	String username = exlread.getCellData("Logininfo", "UserName", 2);
	String password = exlread.getCellData("Logininfo", "Password", 2);
	@Test
	public void validUserShouldBeAbleToLogIn() {
		
	driver=	BrowserFactory.init();
	
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	loginPage.enterUserName(username);
	loginPage.enterPassword(password);
	loginPage.clickSignInButton();
	
	
	DashboardPage dashBoard = PageFactory.initElements(driver,DashboardPage.class);
	dashBoard.verifyDashBoardPage();
	
		BrowserFactory.tearDown();
	}
}
