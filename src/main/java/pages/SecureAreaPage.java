package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecureAreaPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private final By pageTitle = By.cssSelector("div.example > h2");
    private final By logoutButton = By.cssSelector("a.button.secondary.radius");
    private final By validationMessage = By.xpath("//*[@id='flash']");

    public void clickOnLogoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }

    public String getPageTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).getText();
    }

    public String getValidationMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(validationMessage));
        return driver.findElement(validationMessage).getText();
    }
}
