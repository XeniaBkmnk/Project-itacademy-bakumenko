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
        driver.findElement(By.xpath(BlushXpathPage.LOGIN_INPUT_FELD)).click();
    }

    public void clickLoginButtonMain() throws InterruptedException {
        driver.findElement(By.xpath(BlushXpathPage.LOGIN_BUTTON_MAIN)).click();
        Thread.sleep(1000);
    }

    public void sendKeysLoginInputEmail(String newEmail) throws InterruptedException {
        driver.findElement(By.xpath(BlushXpathPage.LOGIN_INPUT_EMAIL)).sendKeys(newEmail);
        Thread.sleep(1000);
    }

    public void sendKeysInputPassword(String newPassword) {
        driver.findElement(By.xpath(BlushXpathPage.LOGIN_INPUT_PASSWORD)).sendKeys(newPassword);
    }

    public String getErrorMessageNonUserEmail() {
        return driver.findElement(By.xpath(BlushXpathPage.ERROR_MESSAGE_NON_USER_EMAIL)).getText();
    }

    public String getErrorMessageNonEmail() {
        return driver.findElement(By.xpath(BlushXpathPage.ERROR_MESSAGE_NON_EMAIL)).getText();
    }

    public String getErrorMessageNonPassword() {
        return driver.findElement(By.xpath(BlushXpathPage.ERROR_MESSAGE_NON_PASSWORD)).getText();
    }

    public String getErrorMessageNonCorrectEmail(){
       return driver.findElement(By.xpath(BlushXpathPage.ERROR_MESSAGE_NON_CORRECT_EMAIL)).getText();
    }

}