package Access.Pay;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class base
{
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		//System.out.println(browserName);

		if (browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Interview\\AccessPay\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver
			driver.manage().window().maximize();

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			// firefox code
		} else if (browserName.equals("IE")) {
//	IE code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}
