package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC16_Hidden_Elements_AJAXpage extends BasePage{
    // --- Locators ---
	private By link =By.xpath("//a[text()='Hidden Elements & AJAX']");
    private By input1          = By.id("input1");
    private By input2          = By.id("input2");
    private By checkbox1       = By.id("checkbox1");
    private By checkbox2       = By.id("checkbox2");
    private By toggleInputBtn  = By.id("toggleInput");
    private By toggleCheckBtn  = By.id("toggleCheckbox");
    private By loadContentBtn  = By.id("loadContent");
    private By ajaxContent     = By.id("ajaxContent");

    public TC16_Hidden_Elements_AJAXpage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }
    public TC16_Hidden_Elements_AJAXpage fillbutton() {
    	driver.findElement(link).click();
    	applyObservationDelay();
        driver.findElement(input1).sendKeys("Hello Input 1");
        applyObservationDelay();


        driver.findElement(toggleInputBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(input2));
        driver.findElement(input2).sendKeys("Hello Input 2");
        applyObservationDelay();

  
        driver.findElement(checkbox1).click();
        applyObservationDelay();

        driver.findElement(toggleCheckBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox2));
        driver.findElement(checkbox2).click();
        applyObservationDelay();

        driver.findElement(loadContentBtn).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(ajaxContent, "AJAX Content Loaded"));
        applyObservationDelay();

        return this;
    }
}
