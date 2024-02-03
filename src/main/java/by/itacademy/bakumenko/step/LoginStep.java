package by.itacademy.bakumenko.step;

import by.itacademy.bakumenko.domain.User;
import by.itacademy.bakumenko.driver.WebDriverSingleton;
import by.itacademy.bakumenko.pages.BlushPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginStep {
    WebDriver driver;
    BlushPage blushPage;
    private static final Logger LOGGER = LogManager.getLogger();

    public LoginStep() {
        this.driver = WebDriverSingleton.getDriver();
        this.blushPage = new BlushPage();
        LOGGER.info("WebDriver is created in LoginStep constructor");
    }

    public void openLoginFormByEmailFillAndSubmit(String email, String password) throws InterruptedException{
        blushPage.openMainPage();
        blushPage.clickLoginInputField();
        blushPage.sendKeysLoginInputEmail(email);
        blushPage.sendKeysInputPassword(password);
        blushPage.clickLoginButtonMain();
    }
}