package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationPage extends BasePage {
    private By email = By.xpath("//input[@id='email']");
    private By password = By.xpath("//input[@id='password']");
    private By wrongEmailMessage = By.xpath("//span[contains(text(),'Please enter a valid email address.')]");
    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public String signIn(String login, String pass) {
        wait.until(ExpectedConditions.presenceOfElementLocated(email));
        driver.findElement(email).sendKeys(login);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(password).submit();

        return driver.findElement(wrongEmailMessage).getText();
    }
}