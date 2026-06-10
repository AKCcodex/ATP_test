
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TC05_ShadowDOMpage extends BasePage{


    // --- Locators ---

    private By Blog = By.xpath("//a[text()='Blog']") ; 	
	private By Youtube = By.xpath("//a[text()='Youtube']") ;

  
    
    public TC05_ShadowDOMpage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }

    // Helper: gets element inside shadow root using JS
    private WebElement getShadowElement(String cssSelector) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript(
            "return document.querySelector('#shadow_host').shadowRoot.querySelector(arguments[0]);",
            cssSelector
        );
    }

  

    public TC05_ShadowDOMpage Blog() {
    	String originalWindow = driver.getWindowHandle();
    	WebElement linkElement = driver.findElement(Blog);
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
    public TC05_ShadowDOMpage text(String fill) {
      
        WebElement textInput = getShadowElement("input[type='text']");
        textInput.sendKeys(fill);

        WebElement check = getShadowElement("input[type='checkbox']");
        check.click();

        applyObservationDelay();
        return this;
    }

    public TC05_ShadowDOMpage upload(String absoluteFilePath) {
        WebElement fileInput = getShadowElement("input[type='file']");
        fileInput.sendKeys(absoluteFilePath);
        applyObservationDelay();
        return this;
    }
    public TC05_ShadowDOMpage Youtube() {
    
    	String originalWindow = driver.getWindowHandle();
    	WebElement linkElement = driver.findElement(Youtube);
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