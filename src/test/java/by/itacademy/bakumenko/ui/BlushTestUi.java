package by.itacademy.bakumenko.ui;

import by.itacademy.bakumenko.domain.User;
import by.itacademy.bakumenko.page.BlushPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlushTestUi extends BaseTest {
    @Test
    public void testLoginNonCorrectEmail() throws InterruptedException {
        BlushPage blushPage = new BlushPage();
        blushPage.openMainPage();
        blushPage.clickLoginInputField();
        blushPage.sendKeysLoginInputEmail(User.getRandomNonCorrectEmail());
        blushPage.sendKeysInputPassword(User.getRandomPassword());
        blushPage.clickLoginButtonMain();
        blushPage.getErrorMessageNonEmail();
        Thread.sleep(1000);
        Assertions.assertEquals("There is no user record corresponding to this identifier. The user may have been deleted.",blushPage.getErrorMessageNonEmail());
    }
}