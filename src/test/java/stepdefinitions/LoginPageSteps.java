package stepdefinitions;

import com.driverManager.CreateDriver;
import com.pages.LoginPage;
import com.pages.SuccessfulLoginPage;
import di.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPageSteps {

    private WebDriver driver;
    LoginPage loginPage;
    SuccessfulLoginPage successfulLoginPage;
    private Context context;

    // Constructor injection of WebDriver from Hooks class
    public LoginPageSteps(Context context) {
        driver = CreateDriver.getInstance().getDriver();
        loginPage = new LoginPage(driver);
        this.context = context;
    }

    @Given("a user is on the login page")
    public void a_user_is_on_the_login_page() {
        Assert.assertEquals(driver.getTitle(),"Test Login | Practice Test Automation");
    }

    @When("a user login with valid username {string} and password {string}")
    public void a_user_login_with_valid_username_and_password(String username, String password) {
        successfulLoginPage = loginPage.SuccessfulLoginToPracticeAutomation(username, password);
        context.setContext("name",username);
        context.setContext("lastname",password);
    }

    @Then("a user is redirected successfulLogin page with {string}")
    public void aUserIsRedirectedSuccessfulLoginPageWith(String successfulLoginMessage) {
        Assert.assertEquals(successfulLoginPage.getSuccessfulLoginMessage(),successfulLoginMessage);
        System.out.println(context.getContext("name")+ " "+context.getContext("lastname"));
    }

    @When("a user login with invalid username {string} and or password {string}")
    public void a_user_login_with_invalid_username_and_or_password(String username, String password) {
        loginPage.UnsuccessfulLoginToPracticeAutomation(username,password);
    }

    @Then("a user is should see a message {string}")
    public void a_user_is_should_see_a_message(String error_message) {
        Assert.assertEquals(loginPage.getErrorMessage(),error_message);
    }


}
