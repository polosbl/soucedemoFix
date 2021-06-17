package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @DataProvider(name = "Items")
    public Object[] items() {
        return new Object[]{
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"
        };
    }

    @Test(dataProvider = "Items")
    public void addProductToCartTest(String item) {
        productSteps
                .loginAndAddItemToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        cartSteps
                .openCartPage(SAUCE_DEMO_CART_URL);
        Assert.assertTrue(cartSteps.isItemElementPresent(item));
    }

    @Test(dataProvider = "Items", retryAnalyzer = Retry.class)
    public void checkProductPriceTest(String item) {
        productSteps
                .loginAndAddItemToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        String productPrice = productSteps.getItemPrice(item);
        cartSteps
                .openCartPage(SAUCE_DEMO_CART_URL);
        Assert.assertEquals(cartSteps.getItemPrice(item), productPrice);
    }

    @Test(dataProvider = "Items", retryAnalyzer = Retry.class)
    public void checkQuantityTest(String item) {
        productSteps
                .loginAndAddItemToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        cartSteps
                .openCartPage(SAUCE_DEMO_CART_URL);
        Assert.assertEquals(cartSteps.getItemQuantity(item), "1");
    }

    @Test(dataProvider = "Items", retryAnalyzer = Retry.class)
    public void removeItemFromCartTest(String item) {
        productSteps
                .loginAndAddItemToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        cartSteps
                .removeItemFromCart(SAUCE_DEMO_CART_URL,item);
        Assert.assertFalse(cartSteps.isItemElementPresent(item));
    }
}
