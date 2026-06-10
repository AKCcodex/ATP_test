

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TC06_tabpage extends BasePage{


    // --- Locators ---
    private By textin = By.id("Wikipedia1_wikipedia-search-input");
    private By search = By.xpath("//input[@class='wikipedia-search-button']");
    private By clickfirst = By.xpath("(//div[@id='Wikipedia1_wikipedia-search-results']//a)[1]");
  
    
    public TC06_tabpage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC06_tabpage text(String fill) {
    	 WebElement textinput = driver.findElement(textin);
    	 textinput.sendKeys(fill);
    	 WebElement searchcheck = driver.findElement(search);
    	 searchcheck.click();
    	 applyObservationDelay();
    	 
    	 String originalWindow = driver.getWindowHandle();
    	 
     	WebElement linkElement = driver.findElement(clickfirst);
         String targetUrl = linkElement.getAttribute("href");


         driver.switchTo().newWindow(WindowType.WINDOW);

         driver.get(targetUrl);


         JavascriptExecutor js = (JavascriptExecutor) driver;

         js.executeScript("window.scrollBy(0, 1000);");
         
         applyObservationDelay();

         driver.close();

         driver.switchTo().window(originalWindow);
    	 return this;
    }
    
}