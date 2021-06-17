package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

public class CartSteps {

    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
    }

    @Step("Opening cart page")
    public CartSteps openCartPage(String url) {
        cartPage
                .openPage(url);
        return this;
    }

    @Step("Getting price from the cart")
    public String getItemQuantity(String item) {
        return cartPage.getItemQuantity(item);
    }

    @Step("Getting quantity from the cart")
    public String getItemPrice(String item) {
        return cartPage.getItemPrice(item);
    }

    @Step("Checking is {item} present int the cart")
    public boolean isItemElementPresent(String item) {
        return cartPage.isItemElementPresent(item);
    }

    @Step("Opening cart and removing item")
    public CartSteps removeItemFromCart(String url, String item) {
        cartPage
                .openPage(url)
                .removeItemFromCart(item);
        return this;
    }

    @Step("Getting current URL")
    public String getCurrentUrl() {
        return cartPage.getCurrentUrl();
    }
}
