package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import steps.CartSteps;
import steps.LoginSteps;
import steps.ProductSteps;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest implements ITestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    ProductSteps productSteps;
    CartSteps cartSteps;
    LoginSteps loginSteps;

    @BeforeMethod
    public void initTest(ITestContext context){
        //TODO: Different browsers (Firefox)
//        if (System.getProperty("browser").equals("chrome")) {
        WebDriverManager.chromedriver().setup();
//      DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//      desiredCapabilities.setCapability("nativeWebScreenshot",true);
        driver = new ChromeDriver();
//        } else if (System.getProperty("browser").equals("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        initPages();
        PageFactory.initElements(driver,this);

        //Screenshots
        String variable = "driver";
        System.out.println("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod (alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

    private void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);
        loginSteps = new LoginSteps(driver);
    }
}
