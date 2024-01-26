package by.itacademy.bakumenko.api;

import by.itacademy.bakumenko.page.BlushApiPage;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class BlushApiTest {
    @Test
    public void testBushLoginNoDate() {
        BlushApiPage.requestHeader().
                body(BlushApiPage.bodyLoginNoData).
                when().post(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("INVALID_EMAIL"));
    }

    @Test
    public void testBushLoginNoPassword() {
        BlushApiPage.requestHeader().
                body(BlushApiPage.bodyLoginNoPassword).
                when().post(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("MISSING_PASSWORD"));
    }

    @Test
    public void testBushLoginNoEmail() {
        BlushApiPage.requestHeader().
                body(BlushApiPage.bodyLoginNoEmail).
                when().post(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("INVALID_EMAIL"));
    }

    @Test
    public void testBushLoginSpacebarInPassword() {
        BlushApiPage.requestHeader().
                body(BlushApiPage.bodyLoginSpacebarInPassword).
                when().body(BlushApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("EMAIL_NOT_FOUND"));
    }

}