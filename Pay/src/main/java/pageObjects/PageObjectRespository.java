package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectRespository {
	public WebDriver driver;


	
	By rdbuttonRoundtrip = By.xpath("//input[@id='roundtrip']");
		

	public PageObjectRespository(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement rdbuttonRoundTrip() {
		return driver.findElement(rdbuttonRoundtrip);
	}

	
}
