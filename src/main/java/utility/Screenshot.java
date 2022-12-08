package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import pojo.Base;

public class Screenshot {
	 public static void screenshot( WebDriver driver,String name) throws IOException  {
	    	String d=Screenshot.date();
	    	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	File destination=new File("C:\\Users\\LA PC MASTER\\Reliance\\Reliance\\Screenshot"+name+""+d+".png");
	    	FileHandler.copy(source, destination);
	    }
	    public static String date() {
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss");
			LocalDateTime currenttime=LocalDateTime.now();
			String d=dtf.format(currenttime);
			return d;
			
		}
	    

}
