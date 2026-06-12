package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.ExtentReportManager;
import java.io.File;
import java.io.IOException;

public class AutomationTest {
     private WebDriver driver;
     private TC00_prelink_explore  prelink_explore;
     private TC01_GUI_Elements guiElements;
     private TC02_Upload_Files uploadFiles;
     private TC03_Table  Table;
     private TC04_FormSectionpage  FormSection;
     private TC05_ShadowDOMpage  ShadowDOMtest;
     private TC06_tabpage  tabstest;
     private TC07_DynamicButtonPage  DynamicButtonTest;
     private TC08_Alertsandpopupspage  Alertsandpopupstest;
     private TC09_MouseHoverpage  MouseHovertest;
     private TC10_doubleClickpage  doubleClicktest;
     private TC11_Draganddroppage  Draganddroptest;
     private TC12_sliderpage  slidertest;
     private TC13_scrollingDropdownpage  scrollingDropdowntest;
     private TC14_LaptopLinkspage  LaptopLinkstest;
     private TC15_verifyBrokenLinkspage  verifyBrokenLinkstest;
     private TC16_Hidden_Elements_AJAXpage   Hidden_Elements_AJAXtest;
     private TC17_downloadpage   downloadtest;
     private static final int OBSERVATION_DELAY = 2000; 
     private static final String BASE_URL = "https://testautomationpractice.blogspot.com";

     @BeforeClass(alwaysRun = true)
     public void setUp() {
         System.out.println("=== STARTING SETUP ===");
         Reporter.log("Opening Chrome Browser...", true);

         driver = BasePage.createDriver();
         driver.manage().window().maximize();

         Reporter.log("Navigating to: " + BASE_URL, true);
         driver.get(BASE_URL);

         // Initializing page objects
         prelink_explore         = new TC00_prelink_explore(driver, OBSERVATION_DELAY);
         guiElements             = new TC01_GUI_Elements(driver, OBSERVATION_DELAY);
         uploadFiles             = new TC02_Upload_Files(driver, OBSERVATION_DELAY);
         Table                   = new TC03_Table(driver, OBSERVATION_DELAY);
         FormSection             = new TC04_FormSectionpage(driver, OBSERVATION_DELAY);
         ShadowDOMtest           = new TC05_ShadowDOMpage(driver, OBSERVATION_DELAY);
         tabstest                = new TC06_tabpage(driver, OBSERVATION_DELAY);
         DynamicButtonTest       = new TC07_DynamicButtonPage(driver, OBSERVATION_DELAY);
         Alertsandpopupstest     = new TC08_Alertsandpopupspage(driver, OBSERVATION_DELAY);
         MouseHovertest          = new TC09_MouseHoverpage(driver, OBSERVATION_DELAY);
         doubleClicktest         = new TC10_doubleClickpage(driver, OBSERVATION_DELAY);
         Draganddroptest         = new TC11_Draganddroppage(driver, OBSERVATION_DELAY);
         slidertest              = new TC12_sliderpage(driver, OBSERVATION_DELAY);
         scrollingDropdowntest   = new TC13_scrollingDropdownpage(driver, OBSERVATION_DELAY);
         LaptopLinkstest         = new TC14_LaptopLinkspage(driver, OBSERVATION_DELAY);
         verifyBrokenLinkstest   = new TC15_verifyBrokenLinkspage(driver, OBSERVATION_DELAY);
         Hidden_Elements_AJAXtest = new TC16_Hidden_Elements_AJAXpage(driver, OBSERVATION_DELAY);
         downloadtest            = new TC17_downloadpage(driver, OBSERVATION_DELAY);

         System.out.println("=== SETUP COMPLETE ===\n");
     }
     @Test(priority = 0, groups = {"pre"})
     public void prelink_explore() {
         System.out.println(">>> Running: Pre Link Explorer");
         Reporter.log("Step: Browsing all navigation bar links...", true);
         ExtentReportManager.logStep("Opening each nav bar link and closing it.");

         prelink_explore.udemy()
                     .Online_Trainings()
                     .Blog()
                     .Playwright();

         Reporter.log("Success: All nav bar links browsed successfully.", true);
         System.out.println("<<< Finished: Pre Link Explorer\n");
     }
    @Test(priority = 1, groups = {"gui"})
    public void GUI_Elements_test() {
        System.out.println(">>> Running: GUI Elements Test");
        Reporter.log("Step: Filling out registration form details...", true);
        ExtentReportManager.logStep("Interacting with input forms, dropdown choices, and calendar dates.");
        
        guiElements.fillPersonalDetails("Ashish Kumar", "ashish@gmail.com", "9876543210", "Patna")
                    .selectGenderAndDays()
                    .selectDropdowns("India", "Green", "Lion")
                    .pickDate1("01/05/2026")
                    .pickDate2("01/05/2026") 
                    .pickDate3("25/04/2025","25/05/2026")
                    .Clickhome();
                    
        Reporter.log("Success: Form elements submitted successfully.", true);
        System.out.println("<<< Finished: GUI Elements Test\n");
    }
    private String getFilePath(String fileName) {
       
        String dockerPath = "/app/testFiles/" + fileName;
        File dockerFile = new File(dockerPath);
        
        if (dockerFile.exists()) {
            return dockerPath;
        }
        
      
        return System.getProperty("user.dir") 
               + "/src/test/resources/testFiles/" 
               + fileName;
    }
    @Test(priority = 2, groups = {"upload"})
    public void Upload_Files_test() throws IOException {
    	
        System.out.println(">>> Running: Upload Files Test");
        Reporter.log("Step: Uploading sample files...", true);
        ExtentReportManager.logStep("Executing OS file-path data uploads for text attachments.");
        String filePath1 = getFilePath("demo1.txt");
        String filePath2 = getFilePath("demo2.txt");
       
        

        uploadFiles.uploadSingleFile(filePath1)
                   .uploadMultiFiles(filePath1, filePath2);
                   
       
       
        
        Reporter.log("Success: File uploads verified.", true);
        System.out.println("<<< Finished: Upload Files Test\n");
    }

    @Test(priority = 3, groups = {"table"})
    public void TableTest() {
        System.out.println(">>> Running: Web Table Test");
        Reporter.log("Step: Auditing table data structures...", true);
        utils.ExtentReportManager.logStep("Verifying static sums, dynamic cells, and pagination cycles.");

        // 1. Static Table Validation
        Reporter.log("Step: Static Table Validation...", true);
        int staticTotal = Table.getStaticTotalPrice();
        System.out.println("[RESULT] Calculated Static Total: " + staticTotal);
        utils.ExtentReportManager.logStep("[RESULT] Calculated Static Total: " + staticTotal);

        // 2. Dynamic Table Extraction
        Reporter.log("Step: Dynamic Table Extraction...", true);
        Table.verifyDynamicValues();
        System.out.println("Dynamic Table Extraction compleate");
        utils.ExtentReportManager.logStep("Dynamic Table Extraction compleate");
        
        // 3. Pagination Engine Execution
        Reporter.log("Step: Traversing pagination sheets...", true);
        double paginationTotal = Table.selectAllProductsAndGetTotal();
        
        System.out.println("[RESULT]Grand Total: $" + String.format("%.2f", paginationTotal));
        utils.ExtentReportManager.logStep("Pagination Grand Total collected: $" + String.format("%.2f", paginationTotal));
        
        

        Reporter.log("Success: Web Table checks pass cleanly.", true);
        System.out.println("<<< Finished: Web Table Test\n");
    }
    
    @Test(priority = 4, groups = {"form"})
    public void Form() {
        System.out.println(">>> Running: Form Sections Test");
        Reporter.log("Step: Typing paragraphs into form sections...", true);
        ExtentReportManager.logStep("Populating paragraphs across structured sections.");
        
        FormSection.section1("This is a paragraph in Section 1.")
                .section2("This is a paragraph in Section 2.")
                .section3("This is a paragraph in Section 3.");
                
        Reporter.log("Success: All form text blocks verified.", true);
        System.out.println("<<< Finished: Form Sections Test\n");
    }

    @Test(priority = 5, groups = {"shadowDom"})
    public void ShadowDOM() throws IOException {
    	 String filePath1 = getFilePath("demo1.txt");
        System.out.println(">>> Running: Shadow DOM Test");
        Reporter.log("Step: ERunning: Shadow DOM Test...", true);
        ExtentReportManager.logStep("Step: Running: Shadow DOM Test...");
        
        ShadowDOMtest.Blog()
        .text("Sample text")
        .upload(filePath1)
        .Youtube();
        Reporter.log("Step: Cleaning up dummy test files...", true);
      
        Reporter.log("Success: Shadow DOM .", true);
        System.out.println("<<< Finished: Shadow DOM Test\n");
    }

    @Test(priority = 6, groups = {"tabs"})
    public void Tabs() throws InterruptedException {
        System.out.println(">>> Running: Browser Tabs Test");
        Reporter.log("Step: Testing dynamic multi-tab features...", true);
        ExtentReportManager.logStep("Switching browser tab views using textual identifiers.");
        
        tabstest.text("cake");
        
        Reporter.log("Success: Browser tabs handled cleanly.", true);
        System.out.println("<<< Finished: Browser Tabs Test\n");
    }

    @Test(priority = 7, groups = {"dynamicButton"})
    public void Dynamic_Button() {
        System.out.println(">>> Running: Dynamic Button Test");
        Reporter.log("Step: Clicking dynamic button element...", true);
        ExtentReportManager.logStep("Step: Clicking dynamic button element...");
        
        DynamicButtonTest.button();
        
        Reporter.log("Success: Dynamic button interaction complete.", true);
        System.out.println("<<< Finished: Dynamic Button Test\n");
    }

    @Test(priority = 8, groups = {"alerts"})
    public void Alertsandpopups() {
        System.out.println(">>> Running: Alerts and Popups Test");
        Reporter.log("Step: Handling alerts, confirms, prompts and child windows...", true);
        ExtentReportManager.logStep("Handling alerts, confirms, prompts and child windows...");
        
        Alertsandpopupstest.simpleAlert()
        .comfirmationAlert(true)
        .PromptAlert("I am BATMAN")
        .NewTab()
        .PopupWindows();
        
        Reporter.log("Success: All popup dialogs resolved.", true);
        System.out.println("<<< Finished: Alerts and Popups Test\n");
    }

    @Test(priority = 9, groups = {"hover"})
    public void MouseHover() {
        System.out.println(">>> Running: Mouse Hover Test");
        Reporter.log("Step: Hovering over menu to reveal links...", true);
        ExtentReportManager.logStep("Using the Actions class API to build a pointer hovering chain.");
        
        MouseHovertest.button();
        
        Reporter.log("Success: Mouse hover dropdown selection completed.", true);
        System.out.println("<<< Finished: Mouse Hover Test\n");
    }

    @Test(priority = 10, groups = {"doubleClick"})
    public void doubleClick() {
        System.out.println(">>> Running: Double Click Test");
        Reporter.log("Step: Simulating double click action...", true);
        ExtentReportManager.logStep("Invoking double-click text duplication scripts.");
        
        doubleClicktest.dclick();
        
        Reporter.log("Success: Double click event registered.", true);
        System.out.println("<<< Finished: Double Click Test\n");
    }

    @Test(priority = 11, groups = {"dragDrop"})
    public void Draganddrop() {
        System.out.println(">>> Running: Drag and Drop Test");
        Reporter.log("Step: Dragging element to drop zone...", true);
        ExtentReportManager.logStep("Holding, shifting, and releasing layout components via Action matrices.");
        
        Draganddroptest.drag();
        
        Reporter.log("Success: Drag and drop operation finished.", true);
        System.out.println("<<< Finished: Drag and Drop Test\n");
    }

    @Test(priority = 12, groups = {"slider"})
    public void slider() {
        System.out.println(">>> Running: Range Slider Test");
        Reporter.log("Step: Shifting minimum and maximum slider bars...", true);
        ExtentReportManager.logStep("Modifying horizontal coordinate ranges via pixel offsets.");
        
        slidertest.moveMinSlider(100).moveMaxSlider(100);
        
        Reporter.log("Success: Slider positions adjusted successfully.", true);
        System.out.println("<<< Finished: Range Slider Test\n");
    }

    @Test(priority = 13, groups = {"dropdown"})
    public void scrollingDropdown() {
        System.out.println(">>> Running: Scrolling Dropdown Test");
        Reporter.log("Step: Locating and picking item from scrollable dropdown...", true);
        ExtentReportManager.logStep("Scanning scroll box elements via programmatic array lists.");
        
        scrollingDropdowntest.scrollclick("Item 7");
        
        Reporter.log("Success: Target item chosen from list.", true);
        System.out.println("<<< Finished: Scrolling Dropdown Test\n");
    }

    @Test(priority = 14, groups = {"laptopLinks"})
    public void LaptopLinks() {
        System.out.println(">>> Running: Laptop External Links Test");
        Reporter.log("Step: Checking store redirection pages (Apple, Dell, Lenovo)...", true);
        ExtentReportManager.logStep("Validating external redirects and executing page scrolls to footers.");
        
        LaptopLinkstest.applecheck().dellcheck().lenovocheck();
        
        Reporter.log("Success: External stores loaded fine.", true);
        System.out.println("<<< Finished: Laptop External Links Test\n");
    }

    @Test(priority = 15, groups = {"brokenLinks"})
    public void verifyBrokenLinks() {
        System.out.println(">>> Running: Broken Links Checker");
        Reporter.log("Step: Scanning HTTP response codes for dead links...", true);
        ExtentReportManager.logStep("Running multi-channel HTTP REST requests via background channels.");
        
        verifyBrokenLinkstest.linkcheckcheck();
        
        Reporter.log("Success: Broken link network sweep finished.", true);
        System.out.println("<<< Finished: Broken Links Checker\n");
    }
    @Test(priority = 16, groups = {"AJAXpage"})
    public void Hidden_Elements_AJAX() {
        System.out.println(">>> Running: Hidden Elements & AJAX Test");
        Reporter.log("Step: Toggling hidden elements and loading AJAX content...", true);
        ExtentReportManager.logStep("Revealing hidden inputs, checkboxes and waiting for AJAX response.");

        Hidden_Elements_AJAXtest.fillbutton();

        Reporter.log("Success: Hidden elements toggled and AJAX content loaded.", true);
        System.out.println("<<< Finished: Hidden Elements & AJAX Test\n");
    }

    @Test(priority = 17, groups = {"download"})
    public void download() {
        System.out.println(">>> Running: Download Test");
        Reporter.log("Step: Triggering file download...", true);
        ExtentReportManager.logStep("Clicking download button");

        downloadtest.flow();

        Reporter.log("Success: File downloaded successfully.", true);
        System.out.println("<<< Finished: Download Test\n");
    }
   

     @AfterClass(alwaysRun = true)
     public void tearDown() {
         System.out.println("=== STARTING TEARDOWN ===");
         if (driver != null) {
             Reporter.log("Closing browser and killing driver session...", true);
             driver.quit();
         }
         System.out.println("=== EXECUTION FINISHED ===");
     }
}