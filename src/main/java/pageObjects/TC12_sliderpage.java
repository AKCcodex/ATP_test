
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TC12_sliderpage extends BasePage{


    // --- Locators ---
	private By minSliderHandle = By.xpath("(//div[contains(@id,'slider-range')]//span)[1]"); 
    private By maxSliderHandle = By.xpath("(//div[contains(@id,'slider-range')]//span)[2]");
    public TC12_sliderpage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC12_sliderpage moveMinSlider(int xOffset) {
        WebElement minHandle = wait.until(ExpectedConditions.visibilityOfElementLocated(minSliderHandle));
        actions.dragAndDropBy(minHandle, -1*(xOffset), 0).perform();
        applyObservationDelay();
        return this;
    }

  
    public TC12_sliderpage moveMaxSlider(int xOffset) {
        WebElement maxHandle = wait.until(ExpectedConditions.visibilityOfElementLocated(maxSliderHandle));
        actions.dragAndDropBy(maxHandle, xOffset, 0).perform();
        applyObservationDelay();
        return this;
    }
    
}