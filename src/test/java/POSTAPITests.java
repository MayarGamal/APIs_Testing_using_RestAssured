
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class POSTAPITests {

    public static String orderId;

    @Test
    public void POSTOrder(){


        String RequestBody = "{ \"bookId\":1 , \"customerName\":\"Mayar\" }";
        String token = GetToken.gettoken();

        Response response = RestAssured.given().
                baseUri("https://simple-books-api.glitch.me").
                header("Authorization", "Bearer " + token).
                header("Content-Type", "application/json").
                basePath("/orders").
                contentType(ContentType.JSON).
                body(RequestBody).
                when().
                post();


        System.out.println("Response: " + response.asString());


        assertEquals(response.getStatusCode(), 201);
        assertTrue(response.jsonPath().getBoolean("created"));


        orderId = response.jsonPath().getString("orderId");
        System.out.println("Order ID: " + orderId);

    }



}

