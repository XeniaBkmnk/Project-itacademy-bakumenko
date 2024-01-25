package by.itacademy.bakumenko.api;

import by.itacademy.bakumenko.page.ApiPage;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class BlushTestApi {
    @Test
    public void testBushLoginNoDate() {
        String body = "{\"email\":\"\"," +
                "\"password\":\" \"," +
                "\"returnSecureToken\":true" +
                "}";
        given().
                body(body).
                header("Content-Type", "application/json").
                when().
                post("https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyDUR6XzgDyhoU9Ad4fw6_aoSTXEmVjuhtE").
                then().
                statusCode(400).
                body("error.errors[0].message", equalTo("INVALID_EMAIL"));
    }

    @Test
    public void testBushLoginNoPassword() {
        ApiPage.requestHeader().body(ApiPage.bodyLoginNoPassword).
                when().post(ApiPage.url).
                then().
                statusCode(400).
                body("error.errors[0].message",equalTo("MISSING_PASSWORD"));
    }

    @Test
    public void testBushLoginNoEmail() {
        String body = "{\"email\":\"\"," +
                "\"password\":\"1234test\"," +
                "\"returnSecureToken\":true" +
                "}";
        given().
                body(body).
                header("Content-Type", "application/json").
                when().
                post("https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyDUR6XzgDyhoU9Ad4fw6_aoSTXEmVjuhtE").
                then().
                body("error.errors[0].message",equalTo("INVALID_EMAIL")).
                statusCode(400);
    }

    @Test
    public void testBushLoginSpacebarInPassword() {
        String body = "{\"email\":\"test12@gmail.com\"," +
                "\"password\":\"   \"," +
                "\"returnSecureToken\":true" +
                "}";
        given().
                body(body).
                header("Content-Type", "application/json").
                when().
                post("https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyDUR6XzgDyhoU9Ad4fw6_aoSTXEmVjuhtE").
                then().
                body("error.errors[0].message",equalTo("EMAIL_NOT_FOUND")).
                statusCode(400);
    }

}