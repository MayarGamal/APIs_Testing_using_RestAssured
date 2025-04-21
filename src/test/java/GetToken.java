public class GetToken {

    public static String gettoken(){

            String requestBody = "{ \"clientName\": \"Mayar\", " +
                    "\"clientEmail\": \"Mayar" + System.currentTimeMillis() + "@example.com\" }";

            return io.restassured.RestAssured
                    .given()
                    .baseUri("https://simple-books-api.glitch.me")
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .post("/api-clients/")
                    .then()
                    .statusCode(201)
                    .extract()
                    .path("accessToken");

    }

}
