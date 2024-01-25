package by.itacademy.bakumenko.page;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BlushApiPage {
    public static String bodyLoginNoData = "{" +
            "\"email\":\"\"," +
            "\"password\":\" \"," +
            "\"returnSecureToken\":true" +
            "}";
    public static String bodyLoginNoPassword = "{" +
            "\"email\":\"test12@gmail.com\"," +
            "\"password\":\"\"," +
            "\"returnSecureToken\":true" +
            "}";
    public static String bodyLoginNoEmail = "{" +
            "\"email\":\"\"," +
            "\"password\":\"1234test\"," +
            "\"returnSecureToken\":true" +
            "}";
    public static String bodyLoginSpacebarInPassword = "{" +
            "\"email\":\"test12@gmail.com\"," +
            "\"password\":\"   \"," +
            "\"returnSecureToken\":true" +
            "}";
    public static String url = "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyDUR6XzgDyhoU9Ad4fw6_aoSTXEmVjuhtE";

    public static RequestSpecification requestHeader() {
        return given().
                contentType("application/json");
    }
}