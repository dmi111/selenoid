package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WalmartTest extends BaseTest{
    private static final String LOGIN = "wrong";
    private static final String PASSWORD = "qwerty";
    private static final String WRONG_EMAIL_MESSAGE = "Please enter a valid email address";

    @Test
    public void checkSearchingProduct() {
        catalogPage = homePage.searchProduct();
        Assert.assertTrue(catalogPage.isProductDisplayed());
    }

    @Test
    public void checkAuthorizationWithWrongEmail() {
        homePage.callAccountMenu();
        Assert.assertTrue(authorizationPage.signIn(LOGIN, PASSWORD).contains(WRONG_EMAIL_MESSAGE));
    }
}