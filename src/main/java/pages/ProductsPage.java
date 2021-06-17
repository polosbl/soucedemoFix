package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends HeaderPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='inventory_item']";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";

    @Step("Adding {itemName} to cart")
    public ProductsPage addItemToCart(String itemName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, itemName))).click();
        return this;
    }

    public boolean isRemoveButtonDisplayed(String itemName) {
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON,itemName))).isDisplayed();
    }

    public boolean isAddToCartButtonDisplayed(String itemName) {
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON,itemName))).isDisplayed();
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, itemName))).getText();
    }

    public ProductsPage removeItemFromCart(String itemName) {
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON,itemName))).click();
        return this;
    }
}
