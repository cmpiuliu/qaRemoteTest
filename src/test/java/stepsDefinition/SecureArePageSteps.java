package stepsDefinition;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;
import pages.SecureAreaPage;
import io.cucumber.java.en.And;
import static org.junit.Assert.assertTrue;

public class SecureArePageSteps {

    private SecureAreaPage secureAreaPage;
    private WebDriver driver;


    public SecureArePageSteps() {
        this.driver = Hooks.driver;
        this.secureAreaPage = new SecureAreaPage(driver);

    }

    @And("The appropriate login validation message {string} is displayed")
    public void theAppropriateValidationMessageIsDisplayed(String expectedValidation) {
        assertTrue(secureAreaPage.getValidationMessage().contains(expectedValidation));
    }

    @And("Click on the Logout button")
    public void clickOnTheLogoutButton() {
        secureAreaPage.clickOnLogoutButton();
    }
}
