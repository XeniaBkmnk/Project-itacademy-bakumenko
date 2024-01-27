package by.itacademy.bakumenko.api;

import by.itacademy.bakumenko.pages.BlushApiPage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class BlushApiTest {
    @Test
    public void testBushLoginNoDate() {
        BlushApiPage.headerContentType().
                body(BlushApiPage.bodyLoginNoData).
                when().post(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("INVALID_EMAIL"));
    }

    @Test
    public void testBushLoginNoPassword() {
        BlushApiPage.headerContentType().
                body(BlushApiPage.bodyLoginNoPassword).
                when().post(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("MISSING_PASSWORD"));
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