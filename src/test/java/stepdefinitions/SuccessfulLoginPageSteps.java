package stepdefinitions;

import com.driverManager.CreateDriver;
import com.pages.LoginPage;
import com.pages.PracticePage;
import com.pages.SuccessfulLoginPage;
import di.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SuccessfulLoginPageSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private SuccessfulLoginPage successfulLoginPage;
    private PracticePage practicePage;
    private Context context;

    // Constructor injection of WebDriver from Hooks class
    public SuccessfulLoginPageSteps(Context context) {
        driver = CreateDriver.getInstance().getDriver();
        loginPage = new LoginPage(driver);
        this.context = context;
    }

    @Given("a user with username {string} and password {string} is on the successful login page")
    public void aUserWithUsernameAndPasswordIsOnTheSuccessfulLoginPage(String username, String password) {
        successfulLoginPage = loginPage.SuccessfulLoginToPracticeAutomation(username, password);
    }

    @When("a user clicks on logout button")
    public void a_user_clicks_on_logout_button() {
        successfulLoginPage.logout();
    }
    @Then("a user is redirected to the login page with title {string}")
    public void a_user_is_redirected_to_the_login_page_with_title(String login_page_title) {
        String login_Page_title = login_page_title.replace("pipe","|");
        Assert.assertEquals(driver.getTitle(),login_Page_title);
    }

    @When("a user clicks on practice tab")
    public void aUserClicksOnPracticeTab() {
        practicePage = successfulLoginPage.goToPracticePage();
    }

    @Then("a user is redirected to practice page with {string}")
    public void aUserIsRedirectedToPracticePageWith(String practice_page_title) {
        Assert.assertEquals(practicePage.getPracticePageTitle(),practice_page_title);
    }
}
