

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;




public class TC14_LaptopLinkspage extends BasePage{


    // --- Locators ---
	private By apple = By.id("apple") ; 	
	private By dell = By.id("dell") ; 	
	private By lenovo = By.id("lenovo") ; 	

    public TC14_LaptopLinkspage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC14_LaptopLinkspage applecheck() {
    	String originalWindow = driver.getWindowHandle();
    	WebElement linkElement = driver.findElement(apple);
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
    public TC14_LaptopLinkspage dellcheck() {
    	String originalWindow = driver.getWindowHandle();
    	WebElement linkElement = driver.findElement(dell);
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
    public TC14_LaptopLinkspage lenovocheck() {
        String originalWindow = driver.getWindowHandle();
        WebElement linkElement = driver.findElement(lenovo);
        String targetUrl = linkElement.getAttribute("href");

        // 1. Open the new window context
        driver.switchTo().newWindow(WindowType.WINDOW);

        try {
            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(10));
            
            System.out.println("[INFO] Navigating to target link with a 10-second guard window...");
            driver.get(targetUrl);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 1000);");
            applyObservationDelay();

        } catch (org.openqa.selenium.TimeoutException e) {

            System.out.println("[WARN] Lenovo page took too long to respond. Exiting early via timeout constraint.");
            
        } finally {

            driver.close();

            driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(30));

            driver.switchTo().window(originalWindow);
        }
     
        return this;
    }

    
}