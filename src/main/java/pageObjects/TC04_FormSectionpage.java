package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC04_FormSectionpage extends BasePage{


    // --- Locators ---
    private By section1 = By.id("input1");
    private By section2 = By.id("input2");
    private By section3 = By.id("input3");
    private By btn1 = By.id("btn1");
    private By btn2 = By.id("btn2");
    private By btn3 = By.id("btn3");
  
    
    public TC04_FormSectionpage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC04_FormSectionpage section1(String fill) {
    	 WebElement section1input = driver.findElement(section1);
    	 section1input.clear();
    	 section1input.sendKeys(fill);
    	 WebElement section1btn = driver.findElement(btn1);
    	 section1btn.click();
    	 applyObservationDelay();
    	 return this;
    }
    public TC04_FormSectionpage section2(String fill) {
   	 WebElement section2input = driver.findElement(section2);
   	 section2input.clear();
   	 section2input.sendKeys(fill);
   	 WebElement section2btn = driver.findElement(btn2);
   	 section2btn.click();
   	applyObservationDelay();
   	 return this;
   }
    public TC04_FormSectionpage section3(String fill) {
   	 WebElement section3input = driver.findElement(section3);
   	 section3input.clear();
   	 section3input.sendKeys(fill);
   	 WebElement section3btn = driver.findElement(btn3);
   	 section3btn.click();
   	applyObservationDelay();
   	 return this;
   }
}