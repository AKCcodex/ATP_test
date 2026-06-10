package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class TC01_GUI_Elements extends BasePage {
 
    // --- Locators ---
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone");
    private By addressField = By.id("textarea");
    private By maleRadio = By.id("male");
    private By sundayCheckbox = By.id("sunday");
    private By mondayCheckbox = By.id("monday");
    private By wednesdayCheckbox = By.id("wednesday");
    private By saturdayCheckbox = By.id("saturday");
    private By countryDropdown = By.id("country");
    private By colorsDropdown = By.id("colors");
    private By sortedlistDropdown = By.id("animals");
    private By datePicker1 = By.id("datepicker");
    private By datePicker2 = By.id("txtDate");
    private By datePicker3Start = By.id("start-date");
    private By datePicker3End = By.id("end-date");
    private By datePicker3click = By.xpath("//button[@class='submit-btn' and @onclick='calculateRange()']");
    private By home = By.id("blog-pager");

    public TC01_GUI_Elements(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }
    
    public TC01_GUI_Elements fillPersonalDetails(String name, String email, String phone, String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(addressField).sendKeys(address);
        applyObservationDelay();
        return this;
    }

    public TC01_GUI_Elements selectGenderAndDays() {
        WebElement gender = driver.findElement(maleRadio);
        if(!gender.isSelected()) gender.click();
        
        WebElement daysunday = driver.findElement(sundayCheckbox);
        if(!daysunday.isSelected()) daysunday.click();
        WebElement daymonday = driver.findElement(mondayCheckbox);
        if(!daymonday.isSelected()) daymonday.click();
        WebElement daywednesday = driver.findElement(wednesdayCheckbox);
        if(!daywednesday.isSelected()) daywednesday.click();
        WebElement daysaturday = driver.findElement(saturdayCheckbox);
        if(!daysaturday.isSelected()) daysaturday.click();
        applyObservationDelay();
        return this;
    }

    public TC01_GUI_Elements selectDropdowns(String country, String color, String animal) {
        Select selectCountry = new Select(driver.findElement(countryDropdown));
        selectCountry.selectByVisibleText(country);

        Select selectColor = new Select(driver.findElement(colorsDropdown));
        selectColor.selectByVisibleText(color);
        applyObservationDelay();
        
        Select sortedlist = new Select(driver.findElement(sortedlistDropdown));
        sortedlist.selectByVisibleText(animal);
        applyObservationDelay();
        return this;
    }
    
    

    public TC01_GUI_Elements pickDate1(String date) {
        WebElement dateElt = driver.findElement(datePicker1);
        dateElt.sendKeys(date);
        dateElt.sendKeys(Keys.ENTER);
        applyObservationDelay();
        return this;
    }
    
    public TC01_GUI_Elements pickDate2(String dateVal) {

        WebElement datepicker2 = driver.findElement(datePicker2);
        

        JavascriptExecutor js = (JavascriptExecutor) driver;
        

        js.executeScript("arguments[0].setAttribute('value', '" + dateVal + "');", datepicker2);
        
        System.out.println("Successfully injected date into Datepicker 2 via JS: " + dateVal);
        
        applyObservationDelay();
        return this;
    }
    
    public TC01_GUI_Elements pickDate3(String startdate,String enddate) {
        WebElement datestart = driver.findElement(datePicker3Start);
        datestart.sendKeys(startdate);
        datestart.sendKeys(Keys.ENTER);
        
        WebElement dateend = driver.findElement(datePicker3End);
        dateend.sendKeys(enddate);
        dateend.sendKeys(Keys.ENTER);
        applyObservationDelay();
        WebElement dateclick = driver.findElement(datePicker3click);
        dateclick.click();
        applyObservationDelay();
        return this;
    }
    
    public TC01_GUI_Elements Clickhome() {
        WebElement home_click = driver.findElement(home);
        home_click.click();
        applyObservationDelay();
        return this;
    }

}