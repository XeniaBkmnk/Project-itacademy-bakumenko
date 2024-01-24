package by.itacademy.bakumenko.ui;

import by.itacademy.bakumenko.page.BlushPage;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlushTestUi {
    @Test
    public void testLoginCheck() throws InterruptedException {
        BlushPage blushPage = new BlushPage();
        blushPage.openMainPage();
        blushPage.clickLoginButtonMain();
        blushPage.getErrorMessageNonPassword();
        blushPage.getErrorMessageNonEmail();
        Assertions.assertEquals("Email is required.", blushPage.getErrorMessageNonEmail());
    }
}