package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Log in with incorrect credentials ({username},{password})")
    public LoginSteps loginWithError(String url, String username, String password) {
        loginPage
                .openPage(url)
                .waitForPageOpened()
                .loginWithError(username, password);
        return this;
    }

    @Step("Log in with incorrect credentials ({username},{password}) and close error message")
    public LoginSteps loginWithErrorAndCloseErrorMessage(String url) {
        loginPage
                .openPage(url)
                .waitForPageOpened()
                .loginWithError("1", "1")
                .closeErrorMessage();
        return this;
    }

    @Step("Log in with correct credentials ({username},{password})")
    public LoginSteps login(String url, String username, String password) {
        loginPage
                .openPage(url)
                .waitForPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Getting error message text")
    public String getErrorMessageText() {
        return loginPage.getErrorMessageText();
    }

    @Step("Checking is error message present")
    public boolean isErrorMessagePresent() {
        return loginPage.isErrorMessagePresent();
    }

    @Step("Getting current URL")
    public String getCurrentUrl() {
        return loginPage.getCurrentUrl();
    }
}
