package appHooks;


import com.driverManager.CreateDriver;
import com.utilities.DateTimeUtility;
import com.utilities.PropertiesUtility;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {

    PropertiesUtility propertiesUtility;
    Properties prop;
    private WebDriver driver;

    @Before()
    public void getProperty() {
        propertiesUtility = new PropertiesUtility();
        prop = propertiesUtility.init_prop();
        String browserName = prop.getProperty("browser");
        boolean isHeadless = Boolean.parseBoolean(prop.getProperty("isHeadless"));
        driver = CreateDriver.getInstance().getDriver(browserName,isHeadless);
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @After(order = 0)
    public void scenarioQuitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After(order = 1)
    public void scenarioTearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_")+"_" + DateTimeUtility.getFormattedDateTimeWIthMiliseconds();
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
