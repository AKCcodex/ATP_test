
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TC11_Draganddroppage extends BasePage{


    // --- Locators ---
	private By sourceElement = By.id("draggable"); 
    private By targetElement = By.id("droppable");
    public TC11_Draganddroppage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC11_Draganddroppage drag() {
    	WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceElement));
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
        

        actions.dragAndDrop(source, target).perform();
        
        applyObservationDelay(); 
        return this;
    	 
    	
    }
    
}