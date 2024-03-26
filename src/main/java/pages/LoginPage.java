package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By usernameField = By.cssSelector("input#username");
    private final By passwordField = By.cssSelector("input#password");
    private final By loginButton = By.cssSelector("button.radius");
    private final By validationMessage = By.xpath("//*[@id='flash']");


    public void insertUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }

    public void insertPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password){
        insertUsername(username);
        insertPassword(password);
    }

    public String getValidationMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(validationMessage));
        return driver.findElement(validationMessage).getText();
    }
}
