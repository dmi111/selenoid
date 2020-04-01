package tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import pages.AuthorizationPage;
import pages.CatalogPage;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {
    private static final String WALMART_URL = "https://www.walmart.com/";
    HomePage homePage;
    AuthorizationPage authorizationPage;
    CatalogPage catalogPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        capabilities.setVersion("74.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                capabilities
        );
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        authorizationPage = new AuthorizationPage(driver);
        catalogPage = new CatalogPage(driver);
        driver.get(WALMART_URL);
    }
}