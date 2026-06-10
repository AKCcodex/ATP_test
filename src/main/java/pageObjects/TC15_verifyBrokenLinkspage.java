package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TC15_verifyBrokenLinkspage extends BasePage {
	private By broken_links =By.xpath("//div[@id='broken-links']//a");
    public TC15_verifyBrokenLinkspage(WebDriver driver, int observationDelayMillis) {
        super(driver, observationDelayMillis);
    }

    public TC15_verifyBrokenLinkspage linkcheckcheck() {
    	
        List<WebElement> allLinks = driver.findElements(broken_links);
        System.out.println("Total links found: " + allLinks.size());

        List<String> urls = new ArrayList<>();
        for (WebElement link : allLinks) {
            urls.add(link.getAttribute("href"));
        }

        String originalUrl = driver.getCurrentUrl();

        for (String url : urls) {
            driver.get(url);
            applyObservationDelay();

            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.setConnectTimeout(3000);
                connection.connect();
                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println("BROKEN  [" + responseCode + "] : " + url);
                } else {
                    System.out.println("VALID   [" + responseCode + "] : " + url);
                }

            } catch (Exception e) {
                System.out.println("ERROR   : " + url + " -> " + e.getMessage());
            }

            driver.navigate().back();
            applyObservationDelay();
        }

        driver.get(originalUrl);
        applyObservationDelay();
        return this;
    }
}