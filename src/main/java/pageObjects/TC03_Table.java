package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC03_Table extends BasePage {
    
    // --- Locators ---
    private By staticTablePrices = By.xpath("//table[@name='BookTable']//tr/td[4]");

    private By chromeCpuDisplay     = By.cssSelector(".chrome-cpu");
    private By firefoxMemoryDisplay = By.cssSelector(".firefox-memory");
    private By chromeNetworkDisplay = By.cssSelector(".chrome-network");
    private By firefoxDiskDisplay   = By.cssSelector(".firefox-disk");

    private By productRows    = By.xpath("//table[@id='productTable']//tbody/tr");
    private By pageLinks      = By.xpath("//ul[@id='pagination']/li/a");
    
    public TC03_Table(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }

 
    public int getStaticTotalPrice() {
        List<WebElement> prices = driver.findElements(staticTablePrices);
        int total = 0;
        for (WebElement price : prices) {
            total += Integer.parseInt(price.getText().trim());
        }
        return total;
    }

   
    public TC03_Table verifyDynamicValues() {
        String chromeCpu     = driver.findElement(chromeCpuDisplay).getText().trim();
        String firefoxMemory = driver.findElement(firefoxMemoryDisplay).getText().trim();
        String chromeNetwork = driver.findElement(chromeNetworkDisplay).getText().trim();
        String firefoxDisk   = driver.findElement(firefoxDiskDisplay).getText().trim();

        System.out.println("[DATA] Chrome CPU: "     + chromeCpu);
        System.out.println("[DATA] Firefox Memory: " + firefoxMemory);
        System.out.println("[DATA] Chrome Network: " + chromeNetwork);
        System.out.println("[DATA] Firefox Disk: "   + firefoxDisk);
        return this;
    }

  
    public double selectAllProductsAndGetTotal() {
        int totalPages = driver.findElements(pageLinks).size();
        double grandTotal = 0;

        for (int i = 1; i <= totalPages; i++) {
           
            By dynamicPage = By.xpath(String.format("(//ul[@id='pagination']/li/a)[%d]", i));
            driver.findElement(dynamicPage).click();
            applyObservationDelay();

            List<WebElement> rows = driver.findElements(productRows);
            for (WebElement row : rows) {
                List<WebElement> cols = row.findElements(By.tagName("td"));

          
                WebElement checkbox = cols.get(3).findElement(By.tagName("input"));
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
   
                double price = Double.parseDouble(cols.get(2).getText().replace("$", "").trim());
                grandTotal += price;

                System.out.println("[INFO] Page " + i + " Checked: " + cols.get(1).getText().trim() + " | Price: " + cols.get(2).getText());
            }
        }
        return grandTotal;
    }
}