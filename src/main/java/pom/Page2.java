package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page2 {

	public String wikiDate;
	public String wikiorgCountry;
	@FindBy(xpath="//input[@title='Search']")private WebElement googleSearch;
	@FindBy(xpath="//input[@type='submit']")private WebElement gSearchbtn;
	@FindBy(xpath="(//h3[text()='Wikipedia, the free encyclopedia'])[1]")private WebElement wiki;
	@FindBy(xpath="//input[@id='searchInput']")private WebElement search;
    @FindBy(xpath="//input[@id='searchButton']") private WebElement searchbtn;	
    @FindBy(xpath="//tbody//tr[12]//li") private WebElement date; 
    @FindBy(xpath="(//td[@class='infobox-data'])[12]") private WebElement country;
    
    public  Page2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    public void googleSearch() {
    	googleSearch.click();
    	googleSearch.sendKeys("https://en.wikipedia.org/wiki/Main_Page");
    	gSearchbtn.click();
    	wiki.click();
    	
    }
    public void searchName() {
    	
    	search.click();
    	search.sendKeys("Pushpa: The Rise");
    	
    }
    public void clickOnSearchbtn() {
    	searchbtn.click();
    }
    public String extractDate() {
    	String wikiDate=date.getText();
    	System.out.println(wikiDate);
    return wikiDate;
    }
	public String extractCountry() {
		String wikiorgCountry=country.getText(); 
		System.out.println(wikiorgCountry);
		return wikiorgCountry;
	}


}
