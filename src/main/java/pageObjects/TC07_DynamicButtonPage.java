
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC07_DynamicButtonPage extends BasePage{


    // --- Locators ---
	private By dynamicStartBtn = By.xpath("//button[@name='start' and contains(@class, 'start')]");
	private By dynamicStopBtn = By.xpath("//button[@name='stop' and contains(@class, 'stop')]");
    public TC07_DynamicButtonPage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC07_DynamicButtonPage button() {
    	 WebElement Dybtnstart = driver.findElement(dynamicStartBtn);
    	 Dybtnstart.click();
    	 applyObservationDelay();
    	 WebElement Dybtnstop = driver.findElement(dynamicStopBtn);
    	 Dybtnstop.click();
    	 applyObservationDelay();
    	 return this;
    }
    
}