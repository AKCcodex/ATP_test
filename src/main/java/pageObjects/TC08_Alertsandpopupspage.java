

package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC08_Alertsandpopupspage extends BasePage{


    // --- Locators ---
	private By simpleAlertBtn = By.id("alertBtn");
    private By confirmAlertBtn = By.id("confirmBtn");
    private By promptAlertBtn = By.id("promptBtn");
    private By newTabBtn = By.xpath("//button[text()='New Tab']");      
    private By popupWindowBtn = By.id("PopUp"); 
    public TC08_Alertsandpopupspage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }



    public TC08_Alertsandpopupspage simpleAlert() {
    	wait.until(ExpectedConditions.elementToBeClickable(simpleAlertBtn)).click();
        applyObservationDelay(); 
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: " + alert.getText());
        alert.accept();

        applyObservationDelay();
        return this;

    }
    public TC08_Alertsandpopupspage comfirmationAlert(boolean accept) {
    	wait.until(ExpectedConditions.elementToBeClickable(confirmAlertBtn)).click();
        applyObservationDelay();

        Alert alert = driver.switchTo().alert();
        System.out.println("Confirmation Alert Text: " + alert.getText());
        
        if (accept) {
            alert.accept(); 
        } else {
            alert.dismiss(); 
        }

        applyObservationDelay();
        return this;
   }
    public TC08_Alertsandpopupspage PromptAlert(String inputText) {
        wait.until(ExpectedConditions.elementToBeClickable(promptAlertBtn)).click();
        applyObservationDelay();

        Alert alert = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: " + alert.getText());

        alert.sendKeys(inputText);
        
        applyObservationDelay();
        alert.accept();

        applyObservationDelay();
        return this;
    }
    public TC08_Alertsandpopupspage NewTab() {
    	

        String mainWindowHandle = driver.getWindowHandle();

   
        wait.until(ExpectedConditions.elementToBeClickable(newTabBtn)).click();
        applyObservationDelay();


        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle); 
                break;
            }
        }
        
        applyObservationDelay();

        driver.close();
        driver.switchTo().window(mainWindowHandle);
        
        return this;

   }
    public TC08_Alertsandpopupspage PopupWindows() {
    	String mainWindowHandle = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(popupWindowBtn)).click();
        applyObservationDelay();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
            	 
                driver.switchTo().window(windowHandle);
                driver.close();
                
            }
        }
        applyObservationDelay();
       
        driver.switchTo().window(mainWindowHandle);
        
        return this;

   }
    
}