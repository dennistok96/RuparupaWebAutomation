package parallel;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp() {
        setDriver();
    }

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        System.out.println("This will run before the Scenario");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Close browser");
        takeScreenshot(scenario);
        getDriver().quit();
    }


    public void takeScreenshot(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());
        }
    }

    public String getBase64Screenshot()
    {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
