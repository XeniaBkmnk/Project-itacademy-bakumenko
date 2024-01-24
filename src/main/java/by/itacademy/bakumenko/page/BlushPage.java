package by.itacademy.bakumenko.page;

import by.itacademy.bakumenko.driver.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlushPage {
    private WebDriver driver;

    public BlushPage() {
        this.driver = MyDriver.getDriver();
    }

    public void openMainPage() {
        driver.get("https://blush.design/");
    }

    public void clickLoginInputField() {
        driver.findElement(By.xpath(BlushPageXpath.LOGIN_INPUT_FEILD)).click();
    }

    public void clickLoginButtonMain() throws InterruptedException {
        driver.findElement(By.xpath(BlushPageXpath.LOGIN_BUTTON_MAIN)).click();
        Thread.sleep(1000);
    }

    public void sendKeysLoginInputEmail() {
        driver.findElement(By.xpath(BlushPageXpath.LOGIN_INPUT_EMAIL)).sendKeys();
    }

    public void sendKeysInputPassword() {
        driver.findElement(By.xpath(BlushPageXpath.LOGIN_INPUT_EMAIL)).sendKeys();
    }

    public String getErrorMessageNonEmail() {
        return driver.findElement(By.xpath(BlushPageXpath.ERROR_MESSAGE_NON_EMAIL)).getText();
    }

    public String getErrorMessageNonPassword() {
        return driver.findElement(By.xpath(BlushPageXpath.ERROR_MESSAGE_NON_PASSWORD)).getText();
    }
}