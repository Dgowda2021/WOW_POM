package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static utilities.ConfigReader.getUrl;

public class BaseLogin {
    public WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        // Initialize WebDriver and perform login steps here
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Navigate to the application URL and perform login actions
        driver.get(getUrl());
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown() {
        // Quit the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }

}
