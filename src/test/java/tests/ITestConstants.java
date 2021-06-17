package tests;

public interface ITestConstants {
    String STANDARD_USER = "standard_user";
    String STANDARD_USER_PASSWORD = "secret_sauce";
    String SAUCE_DEMO_BASE_URL = "https://www.saucedemo.com";
    String SAUCE_DEMO_CART_URL = SAUCE_DEMO_BASE_URL + "/cart.html";
    String SAUCE_DEMO_PRODUCTS_URL = SAUCE_DEMO_BASE_URL + "/inventory.html";
    String EMPTY_FIELDS_ERROR_TEXT = "Epic sadface: Username is required";
    String EMPTY_PASSWORD_FIELD_ERROR_TEXT = "Epic sadface: Password is required";
    String INCORRECT_DATA_IN_FIELDS_ERROR_TEXT =
            "Epic sadface: Username and password do not match any user in this service";
}
