package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogPage extends BasePage {
    private By searchResult = By.xpath("//span[@class='price-characteristic']");
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDisplayed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(searchResult));

        return driver.findElement(searchResult).isDisplayed();
    }
}