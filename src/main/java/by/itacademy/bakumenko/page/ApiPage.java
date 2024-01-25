package by.itacademy.bakumenko.page;

public class ApiPage {
    public String bodyLoginNoData ="{" +
            "\"email\":\"\"," +
            "\"password\":\" \"," +
            "\"returnSecureToken\":true" +
            "}";
    public String bodyLoginNoPassword = "{" +
            "\"email\":\"test12@gmail.com\"," +
            "\"password\":\"\"," +
            "\"returnSecureToken\":true" +
            "}";
    public String bodyLoginNoEmail = "{" +
            "\"email\":\"\"," +
            "\"password\":\"1234test\"," +
            "\"returnSecureToken\":true" +
            "}";
    public String bodyLoginSpacebarInPassword ="{" +
            "\"email\":\"test12@gmail.com\"," +
            "\"password\":\"   \"," +
            "\"returnSecureToken\":true" +
            "}";
    public String url ="https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyDUR6XzgDyhoU9Ad4fw6_aoSTXEmVjuhtE";

}