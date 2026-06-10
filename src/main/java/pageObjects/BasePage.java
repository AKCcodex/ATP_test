package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected int observationDelayMillis;

    public BasePage(WebDriver driver, int observationDelayMillis) {
        this.driver = driver;
        this.observationDelayMillis = observationDelayMillis;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public static WebDriver createDriver() {
        String gridUrl = System.getenv("GRID_URL");
        if (gridUrl != null) {
            // Running in Docker
            try {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                System.out.println("Running on Grid: " + gridUrl);

                RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL(gridUrl), options);
             
                remoteDriver.setFileDetector(new LocalFileDetector());
                return remoteDriver;

            } catch (Exception e) {
                throw new RuntimeException("Failed to connect to Grid: " + e.getMessage());
            }
        } else {
            // Running locally
            System.out.println("Running locally with ChromeDriver");
            return new ChromeDriver();
        }
    }

    protected void applyObservationDelay() {
        if (observationDelayMillis > 0) {
            try {
                Thread.sleep(observationDelayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}