package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC02_Upload_Files extends BasePage{
  

    // --- Locators ---
    private By SinglefileInput = By.id("singleFileInput"); 
    private By fileInputMulti = By.id("multipleFilesInput"); 
    private By SinglefileInputButton = By.xpath("//button[@type='submit' and text()='Upload Single File']");
    private By MultifileInputButton = By.xpath("//button[@type='submit' and text()='Upload Multiple Files']");
  
    public TC02_Upload_Files(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }

    public TC02_Upload_Files uploadSingleFile(String absoluteFilePath) {       
        WebElement uploadElementSingle =driver.findElement(SinglefileInput);
        uploadElementSingle.sendKeys(absoluteFilePath);
        WebElement uploadElementSingleButton =driver.findElement(SinglefileInputButton);
        uploadElementSingleButton.click();
        applyObservationDelay();
        return this; 
    }
    public TC02_Upload_Files uploadMultiFiles(String absoluteFilePath1,String absoluteFilePath2) {
        WebElement uploadElementMulti = driver.findElement(fileInputMulti);
        uploadElementMulti.sendKeys(absoluteFilePath1);
        uploadElementMulti.sendKeys(absoluteFilePath2);
        WebElement uploadElementmultiButton =driver.findElement(MultifileInputButton);
        uploadElementmultiButton.click();
        applyObservationDelay();
        return this; 
    }
}