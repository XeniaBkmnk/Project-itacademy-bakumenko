package by.itacademy.bakumenko.ui;

import by.itacademy.bakumenko.domain.User;
import by.itacademy.bakumenko.pages.BlushPage;
import by.itacademy.bakumenko.pages.LoginStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlushUiTest extends BaseTest {
    BlushPage blushPage = new BlushPage();
    LoginStep loginStep = new LoginStep();
    private static final Logger LOGGER = LogManager.getLogger();
    @Test
    public void testLoginNonUserEmail() throws InterruptedException {
        loginStep.openLoginFormByEmailFillAndSubmit(User.getRandomCorrectEmail(),User.getRandomPassword());
        LOGGER.info("Expected Error Message: " +"There is no user record corresponding to this identifier. The user may have been deleted.");
        Assertions.assertEquals("There is no user record corresponding to this identifier. The user may have been deleted.", blushPage.getErrorMessageNonUserEmail());
    }

    @Test
    public void testLoginNonPassword() throws InterruptedException {
        loginStep.openLoginFormByEmailFillAndSubmit(User.getRandomCorrectEmail(),"");
        Assertions.assertEquals("Password is required.", blushPage.getErrorMessageNonPassword());
    }

    @Test
    public void testLoginNonCorrectEmail() throws InterruptedException {
        loginStep.openLoginFormByEmailFillAndSubmit(User.getRandomNonCorrectEmail(),User.getRandomPassword());
        Assertions.assertEquals("The email address is badly formatted.", blushPage.getErrorMessageNonCorrectEmail());
    }

    @Test
    public void testSearchAuthorMassage() {
        blushPage.openMainPage();
        Assertions.assertEquals("© Blush Design Inc. All rights reserved.", blushPage.getSearchAuthorMassage());
    }

}