package by.itacademy.bakumenko.page;

import by.itacademy.bakumenko.driver.MyDriver;
import org.openqa.selenium.WebDriver;

public class BlushPage {
    private WebDriver driver;

    public BlushPage() {
        this.driver = MyDriver.getDriver();
    }

    public void openMainPage() {
        driver.get("https://blush.design/");
    }
}