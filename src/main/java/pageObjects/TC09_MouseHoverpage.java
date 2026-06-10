package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC09_MouseHoverpage extends BasePage {

    private By hoverButton = By.className("dropbtn");
    private By mobielsLink = By.xpath("//div[@class='dropdown-content']/a[text()='Mobiles']");
   

    public TC09_MouseHoverpage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }

    public TC09_MouseHoverpage button() {

        WebElement mainButton = wait.until(ExpectedConditions.visibilityOfElementLocated(hoverButton));
        actions.moveToElement(mainButton).perform();
        applyObservationDelay();


        WebElement mobiles = wait.until(ExpectedConditions.elementToBeClickable(mobielsLink));
        actions.moveToElement(mobiles).click().perform();
        applyObservationDelay();


        return this;
    }
}