package Access.Pay;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class flightbooking {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		//System.setProperty(“webdriver.chrome.driver”, new File(“./src/test/resources/drivers/chromedriver.exe”).getCanonicalPath());
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.airindia.in");
		System.out.println("Step - 1 Executed");

		System.out.println(driver.getTitle());
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Welcome to Air India";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println("Step - 2 Executed");


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'One Way')]")));

		driver.findElement(By.xpath("//label[contains(text(),'One Way')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'One Way')]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='oneway']")).isSelected());
		
		System.out.println("Step - 3 Executed");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Round Trip')]")));

		driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='roundtrip']")).isSelected());
		System.out.println("Step - 4 Executed");

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'One Way')]")));
		driver.findElement(By.xpath("//label[contains(text(),'One Way')]")).click();
		System.out.println("Step - 5 Executed");

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Round Trip')]")));
		driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();
		System.out.println("Step - 6 Executed");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'One Way')]")));
		driver.findElement(By.xpath("//label[contains(text(),'One Way')]")).click();
		System.out.println("Step - 7 Executed");
		// ----------------------------------------------------------------------------------------------------------------------------



		// ----------------------------------------------------------------------------------------------------------------------------
		/*
		 * if (driver.findElement(By.xpath("//label[contains(text(),'One Way')]")).
		 * isSelected()) { System.out.println("2 way is selected");
		 * 
		 * } else { System.out.println("1 way is selected"); }
		 */

		driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]")).click();

		driver.findElement(By.cssSelector("#btnbooking")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#spnfrom1")).isDisplayed());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ----------------------------------------------------------------------------------------------------------------------------
		String fromAirport = driver.findElement(By.cssSelector("#spnfrom1")).getText();
		String toAirport = driver.findElement(By.cssSelector(" #spnto1")).getText();

		System.out.println(fromAirport);
		System.out.println(toAirport);
		
		//----------------------------------------------------------------------------------------------------------------------------
		
		if (fromAirport.equals("Select from airport")) {
			
			driver.findElement(By.xpath("//input[@id='from']")).sendKeys("London");
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
			System.out.println("Step - 8 Executed");
			driver.findElement(By.cssSelector("#btnbooking")).click();
			
			if (driver.findElement(By.cssSelector("#spnfrom1")).isDisplayed())
			Assert.assertFalse(false);
						
			else if (toAirport.equals("Select to airport"))
			{
				driver.findElement(By.xpath("//input[@id='to']")).sendKeys("Chennai");
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
				System.out.println("Step - 9 Executed");
				if (driver.findElement(By.cssSelector(" #spnto1")).isDisplayed())
					Assert.assertFalse(false);
			}
		  
		}
		
		driver.findElement(By.xpath("//input[@id='_depdateeu1']")).sendKeys("30/07/2021");
		driver.findElement(By.xpath("//input[@id='_depdateeu1']")).sendKeys(Keys.RETURN);
		
		//input[@id='_depdateeu1']
		
		
		//Assert.assertEquals("30/07/2021", actual);
		
		

		driver.findElement(By.xpath("//input[@id='_retdateeu1']")).sendKeys("25/08/2021");
		driver.findElement(By.xpath("//input[@id='_retdateeu1']")).sendKeys(Keys.RETURN);
		System.out.println("Step - 10 Executed");
		
		
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
		//driver.quit();
		

		

	}

}
