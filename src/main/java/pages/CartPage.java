package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";

    public CartPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, itemName))).getText();
    }

    public String getItemQuantity(String itemQuantity) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY,itemQuantity))).getText();
    }

    @Step("Removing {itemName} from cart")
    public CartPage removeItemFromCart(String itemName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON,itemName))).click();
        return this;
    }

    public boolean isItemElementPresent(String itemName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, itemName))).isEmpty();
    }
}
