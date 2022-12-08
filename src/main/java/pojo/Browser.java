package pojo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	public static  WebDriver openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    return driver;	    
	}

}
