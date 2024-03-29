package by.itacademy.bakumenko.pages;

import by.itacademy.bakumenko.driver.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BlushPage {
    private WebDriver driver;

    public BlushPage() {
        this.driver = WebDriverSingleton.getDriver();
    }

    public void openMainPage() {
        driver.get("https://blush.design/");
    }

    public void clickLoginInputField() {
        driver.findElement(By.xpath(BlushXpathPage.LOGIN_INPUT_FIELD)).click();
    }

    public void clickLoginButtonMain() throws InterruptedException {
        driver.findElement(By.xpath(BlushXpathPage.LOGIN_BUTTON_MAIN)).click();
        Thread.sleep(4000);
    }

    public void sendKeysLoginInputEmail(String newEmail) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            driver.findElement(By.xpath(BlushXpathPage.LOGIN_INPUT_EMAIL)).sendKeys(newEmail);
        } catch (NoSuchElementException e) {
            try {
                driver.findElement(By.xpath("//*[contains(@id, 'email')]")).sendKeys(newEmail);
            } catch (NoSuchElementException ex) {
                driver.findElement(By.xpath("//input[@id='email']\\")).sendKeys(newEmail);
            }
        }
    }

    public void sendKeysInputPassword(String newPassword) {
        driver.findElement(By.xpath(BlushXpathPage.LOGIN_INPUT_PASSWORD)).sendKeys(newPassword);
    }

    public String getErrorMessageNonUserEmail() {
        return driver.findElement(By.xpath(BlushXpathPage.ERROR_MESSAGE_NON_USER_EMAIL)).getText();
    }

    public String getErrorMessageNoEmail() {
        return driver.findElement(By.xpath(BlushXpathPage.ERROR_MESSAGE_NO_EMAIL)).getText();
    }

    public String getErrorMessageNonPassword() {
        return driver.findElement(By.xpath(BlushXpathPage.ERROR_MESSAGE_NON_PASSWORD)).getText();
    }

    public String getErrorMessageNonCorrectEmail() {
        return driver.findElement(By.xpath(BlushXpathPage.ERROR_MESSAGE_NON_CORRECT_EMAIL)).getText();
    }

    public String getSearchAuthorMassage() {
        return driver.findElement(By.xpath(BlushXpathPage.SEARCH_AUTHOR_MASSAGE)).getText();
    }

    public void sendKeysSearchBar(String newSearchElement) {
        WebElement searchBar = driver.findElement(By.xpath(BlushXpathPage.SEARCH_BAR));
        searchBar.sendKeys(newSearchElement);
        searchBar.submit();
    }

    public String getTitleText() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(By.xpath(BlushXpathPage.TITLE_TEXT)).getText();
    }

}