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

    public void sendKeysLoginInputEmail(String newEmail) throws InterruptedException {
        driver.findElement(By.xpath(BlushPageXpath.LOGIN_INPUT_EMAIL)).sendKeys(newEmail);
        Thread.sleep(1000);
    }

    public void sendKeysInputPassword(String newPassword) {
        driver.findElement(By.xpath(BlushPageXpath.LOGIN_INPUT_PASSWORD)).sendKeys(newPassword);
    }

    public String getErrorMessageNonEmail() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(By.xpath(BlushPageXpath.ERROR_MESSAGE_NON_EMAIL)).getText();
    }

    public String getErrorMessageNonPassword() {
        return driver.findElement(By.xpath(BlushPageXpath.ERROR_MESSAGE_NON_PASSWORD)).getText();
    }
}