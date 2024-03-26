package stepsDefinition;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SecureAreaPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginPageSteps {

    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;
    private WebDriver driver;

    public LoginPageSteps() {
        this.driver = Hooks.driver;
        this.loginPage = new LoginPage(driver);
        this.secureAreaPage = new SecureAreaPage(driver);
    }


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
    }


    @When("User enters credentials {string}, {string}")
    public void userEntersCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @And("Click on the Login button")
    public void clickOnTheLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("The appropriate error message {string} is displayed")
    public void theAppropriateErrorMessageIsDisplayed(String expectedValidation) {
        assertTrue(loginPage.getValidationMessage().contains(expectedValidation));

    }

    @Then("User is successfully logged in to the landing page")
    public void userIsSuccessfullyLoggedInToTheLandingPage() {
        assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());

    }

    @And("The appropriate logout validation message {string} is displayed")
    public void theAppropriateValidationMessageIsDisplayed(String expectedValidation) {
        assertTrue(loginPage.getValidationMessage().contains(expectedValidation));

    }

    @Then("User is successfully logged out")
    public void userIsSuccessfullyLoggedOut() {
        assertEquals("https://the-internet.herokuapp.com/login", driver.getCurrentUrl());

    }
}

