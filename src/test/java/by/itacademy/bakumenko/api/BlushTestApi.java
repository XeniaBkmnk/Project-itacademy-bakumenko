package by.itacademy.bakumenko.api;

import by.itacademy.bakumenko.page.ApiPage;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class BlushTestApi {
    @Test
    public void testBushLoginNoDate() {
        ApiPage.requestHeader().body(ApiPage.bodyLoginNoData).
                when().post(ApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("INVALID_EMAIL"));
    }

    @Test
    public void testBushLoginNoPassword() {
        ApiPage.requestHeader().body(ApiPage.bodyLoginNoPassword).
                when().post(ApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("MISSING_PASSWORD"));
    }

    @Test
    public void testBushLoginNoEmail() {
        ApiPage.requestHeader().body(ApiPage.bodyLoginNoEmail).
                when().post(ApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("INVALID_EMAIL"));
    }

    @Test
    public void testBushLoginSpacebarInPassword() {
        ApiPage.requestHeader().body(ApiPage.bodyLoginSpacebarInPassword).
                when().body(ApiPage.url).
                then().
                statusCode(400).body("error.errors[0].message", equalTo("EMAIL_NOT_FOUND"));
    }

}