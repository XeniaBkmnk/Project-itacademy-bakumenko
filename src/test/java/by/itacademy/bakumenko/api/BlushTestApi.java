package by.itacademy.bakumenko.api;

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
        String body = "{\"email\":\"test12@gmail.com\"," +
                "\"password\":\"\"," +
                "\"returnSecureToken\":true" +
                "}";
        given().
                body(body).
                header("Content-Type", "application/json").
                when().
                post("https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyDUR6XzgDyhoU9Ad4fw6_aoSTXEmVjuhtE").
                then().
                log().all();
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
                log().all();
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
                log().all();
    }

    @Test
    public void testBushLoginNoPassword3() {
        String body = "{\"email\":\"///\"," +
                "\"password\":\"1234test\"," +
                "\"returnSecureToken\":true" +
                "}";
        given().
                body(body).
                header("Content-Type", "application/json").
                when().
                post("https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyDUR6XzgDyhoU9Ad4fw6_aoSTXEmVjuhtE").
                then().
                log().all();
    }

}