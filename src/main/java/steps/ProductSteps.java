package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Log in and add {item} to cart")
    public ProductSteps loginAndAddItemToCart(String url, String username, String password, String item) {
        loginPage
                .openPage(url)
                .waitForPageOpened()
                .login(username, password)
                .addItemToCart(item);
        return this;
    }

    @Step("Getting {item}'s price from the catalog")
    public String getItemPrice(String item) {
        return productsPage.getItemPrice(item);
    }

    @Step("Getting current URL")
    public String getCurrentUrl() {
        return productsPage.getCurrentUrl();
    }

    @Step("Checking is Add button displayed")
    public boolean isAddToCartButtonDisplayed(String item) {
        return productsPage.isAddToCartButtonDisplayed(item);
    }

    @Step("Checking is Remove button displayed")
    public boolean isRemoveButtonDisplayed(String item) {
        return productsPage.isRemoveButtonDisplayed(item);
    }
}
