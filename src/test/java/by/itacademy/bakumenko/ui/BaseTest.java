package by.itacademy.bakumenko.ui;

import by.itacademy.bakumenko.driver.MyDriver;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    @AfterEach
    public void baseFinish() throws InterruptedException {
        Thread.sleep(2000);
        if (MyDriver.getDriver() != null) {
            MyDriver.quitDriver();
        }
    }
}