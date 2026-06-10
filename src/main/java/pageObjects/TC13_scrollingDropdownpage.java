

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class TC13_scrollingDropdownpage extends BasePage{


    // --- Locators ---
	private By dropdownTrigger = By.id("comboBox") ; 	

    public TC13_scrollingDropdownpage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC13_scrollingDropdownpage scrollclick(String target) {
    	WebElement dropdown = driver.findElement(dropdownTrigger);
    	dropdown.click();

    	WebElement targetOption = driver.findElement(By.xpath("//div[text()='"+target+"']"));

    
    	Actions actions = new Actions(driver);
    	actions.scrollToElement(targetOption).perform();
    	 
   
    	targetOption.click();
    	 applyObservationDelay();
        return this;
    }

    
}