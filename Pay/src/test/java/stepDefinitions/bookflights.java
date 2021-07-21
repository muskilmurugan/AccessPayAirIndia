package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Access.Pay.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class bookflights extends base {

	@Given("^Open browser and initialze the browser with driver$")
	public void open_browser_and_initialze_the_browser_with_driver() throws Throwable {
		driver = initializeDriver();

	}

	@Given("^Navigate to \"([^\"]*)\" home page$")
	public void navigate_to_home_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);

	}

	@Then("^Validate whether airindia home page landed sucessfully$")
	public void validate_whether_airindia_home_page_landed_sucessfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(driver.getTitle());
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Welcome to Air India";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	@Given("^Validate the default selected option is Round trip$")
	public void validate_the_default_selected_option_is_Round_trip() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Round Trip')]")));
		// Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Round
		// Trip')]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='roundtrip']")).isSelected());
	}

	@When("^Customer selects round trip validate the selections$")
	public void customer_selects_round_trip_validate_the_selections() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'One Way')]")));
		driver.findElement(By.xpath("//label[contains(text(),'One Way')]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='oneway']")).isSelected());
		// Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'One
		// Way')]")).isSelected());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Round Trip')]")));
		driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Round Trip')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='roundtrip']")).isSelected());

	}

	@When("^Customer enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void customer_enters_and(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.cssSelector("#btnbooking")).click();
		// Assert.assertTrue(driver.findElement(By.cssSelector("#spnfrom1")).isDisplayed());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String fromAirport = driver.findElement(By.cssSelector("#spnfrom1")).getText();
		String toAirport = driver.findElement(By.cssSelector(" #spnto1")).getText();

		System.out.println(fromAirport);
		System.out.println(toAirport);
		if (fromAirport.equals("Select from airport")) {

			driver.findElement(By.xpath("//input[@id='from']")).sendKeys(arg1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//input[@id='from']")).sendKeys(Keys.ARROW_DOWN);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//input[@id='from']")).sendKeys(Keys.RETURN);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.cssSelector("#btnbooking")).click();

			if (driver.findElement(By.cssSelector("#spnfrom1")).isDisplayed())
				Assert.assertTrue(true);

			else if (toAirport.equals("Select to airport")) {
				driver.findElement(By.xpath("//input[@id='to']")).sendKeys(arg2);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//input[@id='to']")).sendKeys(Keys.ARROW_DOWN);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//input[@id='to']")).sendKeys(Keys.RETURN);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.cssSelector("#btnbooking")).click();
				if (driver.findElement(By.cssSelector(" #spnto1")).isDisplayed())
					Assert.assertTrue(true);
			}
		}

	}

	@Then("^Click on submit & close the browser$")
	public void click_on_submit_close_the_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@id='_depdateeu1']")).sendKeys("30/07/2021");
		driver.findElement(By.xpath("//input[@id='_depdateeu1']")).sendKeys(Keys.RETURN);

		// input[@id='_depdateeu1']

		// Assert.assertEquals("30/07/2021", actual);

		driver.findElement(By.xpath("//input[@id='_retdateeu1']")).sendKeys("25/08/2021");
		driver.findElement(By.xpath("//input[@id='_retdateeu1']")).sendKeys(Keys.RETURN);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector("#btnbooking")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(driver.getTitle());
		String ActualTitle1 = driver.getTitle();
		String ExpectedTitle1 = "Welcome to Air India";
		Assert.assertNotEquals(ExpectedTitle1, ActualTitle1);
		driver.quit();

	}

}
