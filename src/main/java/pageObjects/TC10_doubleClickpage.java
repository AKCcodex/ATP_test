
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class TC10_doubleClickpage extends BasePage{


    // --- Locators ---
	private By clickmarker = By.xpath("//button[text()='Copy Text']");  
    public TC10_doubleClickpage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC10_doubleClickpage dclick() {
    	 WebElement element = driver.findElement(clickmarker);

          Actions actions = new Actions(driver);
         actions.doubleClick(element).perform();
    	
    	 
    	 return this;
    }
    
}