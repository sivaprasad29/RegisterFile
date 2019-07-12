package Team4.Cucu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	static WebDriver driver;

	public static WebDriver startBrowser(String browsername, String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Siva Prasad\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

}
