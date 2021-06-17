package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @DataProvider(name = "Items and prices")
    public Object[][] itemsAndPrices() {
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99"},
                {"Sauce Labs Bike Light", "$9.99"},
                {"Sauce Labs Bolt T-Shirt", "$15.99"},
                {"Sauce Labs Fleece Jacket", "$49.99"},
                {"Sauce Labs Onesie", "$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99"}
        };
    }

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
    public void isAddToCartButtonDisplayedTest(String item) {
        loginSteps
                .login(SAUCE_DEMO_BASE_URL,STANDARD_USER, STANDARD_USER_PASSWORD);
        Assert.assertTrue(productSteps.isAddToCartButtonDisplayed(item));
    }

    @Test(dataProvider = "Items")
    public void isRemoveButtonDisplayedTest(String item) {
        productSteps
                .loginAndAddItemToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        Assert.assertTrue(productSteps.isRemoveButtonDisplayed(item));
    }


    @Test(dataProvider = "Items and prices")
    public void checkItemPriceTest(String item, String price) {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD);
        Assert.assertEquals(productsPage.getItemPrice(item), price);
    }

    @Test(dataProvider = "Items")
    public void removeItemFromCartTest(String item) {
        productSteps
                .loginAndAddItemToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        productsPage
                .removeItemFromCart(item);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL);
        Assert.assertFalse(cartPage.isItemElementPresent(item));
    }
}
