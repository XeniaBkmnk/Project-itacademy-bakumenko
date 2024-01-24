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

    public void clickLoginButtonMain() {
        driver.findElement(By.xpath(BlushPageXpath.LOGIN_BUTTON_MAIN)).click();
    }
    public void clickLoginInputEmail(){
        driver.findElement(By.xpath(BlushPageXpath.LOGIN_INPUT_EMAIL)).click();
    }
}