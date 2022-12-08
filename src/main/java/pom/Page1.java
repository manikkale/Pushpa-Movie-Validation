package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page1 {

	public String imdbDate;
	public String imdborgCountry;
	@FindBy(xpath="//input[@title='Search']")private WebElement googleSearch;
	@FindBy(xpath="//input[@type='submit']")private WebElement gSearchbtn;
	@FindBy(xpath="//h3[text()='IMDb: Ratings, Reviews, and Where to Watch the Best Movies ...']")private WebElement imdb;
	@FindBy(xpath="//*[@name='q']")private WebElement search;
    @FindBy(xpath="//*[@type='submit']") private WebElement searchbtn;	
    @FindBy(xpath="//a[text()='Pushpa: The Rise - Part 1']") private WebElement name;
    @FindBy(xpath="//span[text()='Details']") private WebElement details;
    @FindBy(xpath="(//a[@href='/title/tt9389998/releaseinfo?ref_=tt_dt_rdat'])[2]") private WebElement date; 
    @FindBy(xpath="//a[@href='/search/title/?country_of_origin=IN&ref_=tt_dt_cn']") private WebElement country;
    
    
  
	
    public  Page1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    public void googleSearch() {
    	googleSearch.click();
    	googleSearch.sendKeys("https://www.imdb.com/?ref_=nv_home");
    	gSearchbtn.click();
    	imdb.click();
    	
    }
    public void searchName() {
    	
    	search.click();
    	search.sendKeys("Pushpa: The Rise");
    	
    }
    public void clickOnSearchbtn() {
    	searchbtn.click();
    }
    public void clickOnName() {
    	name.click();
    }
    public void scroll(WebDriver driver) {
    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",details);
    }
    public String extractDate()  {
    	 String imdbDate=date.getText();
      	System.out.println(imdbDate);
      	return imdbDate;
      	    }
	public String extractCountry() {
		String imdborgCountry1=country.getText(); 
		System.out.println(imdborgCountry1);
		return imdborgCountry1;
	}

}
