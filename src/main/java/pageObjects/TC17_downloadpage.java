
package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TC17_downloadpage extends BasePage{
    // --- Locators ---
	private By link =By.xpath("//a[text()='Download Files']");
    private By input1          = By.id("inputText");
    private By generatebtn          = By.id("generateTxt");
    private By txtDownloadLink       = By.id("txtDownloadLink");
    private By generatePdf       = By.id("generatePdf");
    private By pdfDownloadLink  = By.id("pdfDownloadLink");
    private By generatePDFFile  = By.xpath("//button[text()='Download PDF File']");
   
    public TC17_downloadpage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }
    public TC17_downloadpage flow() {
    	driver.findElement(link).click();
    	applyObservationDelay();
        driver.findElement(input1).sendKeys("I am BatMan");
        applyObservationDelay();


        driver.findElement(generatebtn).click();
        applyObservationDelay();
        driver.findElement(txtDownloadLink).click();
        applyObservationDelay();
        driver.findElement(generatePdf).click();
        applyObservationDelay();
        driver.findElement(pdfDownloadLink).click();
        applyObservationDelay();
        driver.findElement(generatePDFFile).click();
        applyObservationDelay();
      
        
        return this;
    }
}
