

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;




public class TC00_prelink_explore extends BasePage{


    // --- Locators ---
	private By udemylink = By.xpath("//a[text()='Udemy Courses']") ; 	
	private By Online_Trainingslink = By.xpath("//a[text()='Online Trainings']") ; 	
	private By Bloglink = By.xpath("//a[text()='Blog']") ; 	
	private By PlaywrightPracticelink = By.xpath("//a[text()='PlaywrightPractice']") ; 	

    public TC00_prelink_explore(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC00_prelink_explore udemy() {
    	String originalWindow = driver.getWindowHandle();
    	WebElement linkElement = driver.findElement(udemylink);
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
    public TC00_prelink_explore Online_Trainings() {
    	String originalWindow = driver.getWindowHandle();
    	WebElement linkElement = driver.findElement(Online_Trainingslink);
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
    public TC00_prelink_explore Blog() {
    	String originalWindow = driver.getWindowHandle();
    	WebElement linkElement = driver.findElement(Bloglink);
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
    public TC00_prelink_explore Playwright() {
    	String originalWindow = driver.getWindowHandle();
    	WebElement linkElement = driver.findElement(PlaywrightPracticelink);
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