package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	
	public void selectDropDown(WebElement element, String VisibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(VisibleText);
	}
	
	public int generateNumber(int boundary) {
		
		Random rnd = new Random();
		int generatedNumber = rnd.nextInt(boundary)+100;
		return generatedNumber;
		
	}
	
	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(elementLocator));
	}
}
