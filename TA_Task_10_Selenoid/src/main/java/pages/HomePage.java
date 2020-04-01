package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private By searchBox = By.xpath("//input[@id='global-search-input']");
    private By accountButton = By.xpath("//button[@id='header-account-toggle']");
    private By signInButton = By.xpath("//div[contains(text(),'Sign In')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CatalogPage searchProduct() {
        driver.findElement(searchBox).sendKeys("iphone 11");
        driver.findElement(searchBox).submit();

        return new CatalogPage(driver);
    }

    public AuthorizationPage callAccountMenu() {
        driver.findElement(accountButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();

        return new AuthorizationPage(driver);
    }
}