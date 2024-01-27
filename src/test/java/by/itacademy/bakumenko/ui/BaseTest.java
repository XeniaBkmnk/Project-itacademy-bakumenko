package by.itacademy.bakumenko.ui;

import by.itacademy.bakumenko.driver.WebDriverSingleton;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    @AfterEach
    public void baseFinish() throws InterruptedException {
        Thread.sleep(4000);
        if (WebDriverSingleton.getDriver() != null) {
            WebDriverSingleton.quitDriver();
        }
    }
}