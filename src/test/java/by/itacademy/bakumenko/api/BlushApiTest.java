package by.itacademy.bakumenko.api;

import by.itacademy.bakumenko.pages.BlushApiPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class BlushApiTest {
    private static final Logger LOGGER = LogManager.getLogger();
    @Test
    public void testBushLoginNoDate() {
        LOGGER.info("testBushLoginNoDate started");
        BlushApiPage.headerContentType().
                body(BlushApiPage.bodyLoginNoData).
                when().post(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("INVALID_EMAIL"));
        LOGGER.info("testBushLoginNoDate passed");
    }

    @Test
    public void testBushLoginNoPassword() {
        LOGGER.info("testBushLoginNoPassword started");
        BlushApiPage.headerContentType().
                body(BlushApiPage.bodyLoginNoPassword).
                when().post(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("MISSING_PASSWORD"));
        LOGGER.info("testBushLoginNoPassword passed");
    }

    @Test
    public void testBushLoginNoEmail() {
        BlushApiPage.headerContentType().
                body(BlushApiPage.bodyLoginNoEmail).
                when().post(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("INVALID_EMAIL"));
    }

    @Test
    public void testBushLoginSpacebarInPassword() {
        BlushApiPage.headerContentType().
                body(BlushApiPage.bodyLoginSpacebarInPassword).
                when().body(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("EMAIL_NOT_FOUND"));
    }

}