package by.itacademy.bakumenko.ui;

import by.itacademy.bakumenko.domain.User;
import by.itacademy.bakumenko.pages.BlushPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlushUiTest extends BaseTest {
    @Test
    public void testLoginNonUserEmail() throws InterruptedException {
        BlushPage blushPage = new BlushPage();
        blushPage.openMainPage();
        blushPage.clickLoginInputField();
        blushPage.sendKeysLoginInputEmail(User.getRandomCorrectEmail());
        blushPage.sendKeysInputPassword(User.getRandomPassword());
        blushPage.clickLoginButtonMain();
                Assertions.assertEquals("There is no user record corresponding to this identifier. The user may have been deleted.", blushPage.getErrorMessageNonUserEmail());
    }

    @Test
    public void testLoginNonPassword() throws InterruptedException {
        BlushPage blushPage = new BlushPage();
        blushPage.openMainPage();
        blushPage.clickLoginInputField();
        blushPage.sendKeysLoginInputEmail(User.getRandomCorrectEmail());
        blushPage.sendKeysInputPassword("");
        blushPage.clickLoginButtonMain();
               Assertions.assertEquals("Password is required.", blushPage.getErrorMessageNonPassword());
    }

    @Test
    public void testLoginNonCorrectEmail() throws InterruptedException {
        BlushPage blushPage = new BlushPage();
        blushPage.openMainPage();
        blushPage.clickLoginInputField();
        blushPage.sendKeysLoginInputEmail(User.getRandomNonCorrectEmail());
        blushPage.sendKeysInputPassword(User.getRandomPassword());
        blushPage.clickLoginButtonMain();
               Assertions.assertEquals("The email address is badly formatted.", blushPage.getErrorMessageNonCorrectEmail());
    }

}