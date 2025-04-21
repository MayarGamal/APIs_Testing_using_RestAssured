import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PatchAPITest {

@Test
    public void PatchOrder(){

    String RequestBody = "{ \"bookId\":1 , \"customerName\":\"Mayar\" }";
    String token = GetToken.gettoken();
    Response Postresponse = RestAssured.given().
            baseUri("https://simple-books-api.glitch.me").
            header("Authorization", "Bearer " + token).
            header("Content-Type", "application/json").
            basePath("/orders").
            contentType(ContentType.JSON).
            body(RequestBody).
            when().
            post();
    System.out.println("Postresponse: " + Postresponse.asString());
    assertEquals(Postresponse.getStatusCode(), 201);
    assertTrue(Postresponse.jsonPath().getBoolean("created"));
    String orderId;
    orderId = Postresponse.jsonPath().getString("orderId");
    System.out.println("Order ID: " + orderId);

    String PatchBody = "{\"customerName\":\"Ahmed\" }";
    Response Patchresponse = RestAssured.given().
            baseUri("https://simple-books-api.glitch.me").
            header("Authorization", "Bearer " + token).
            header("Content-Type", "application/json").
            contentType(ContentType.JSON).
            body(PatchBody).
            patch("/orders/" + orderId );
    System.out.println("Patchresponse: " + Patchresponse.asString());
    assertEquals(Patchresponse.getStatusCode(), 204);

    Response GetResponse= given().
            baseUri("https://simple-books-api.glitch.me").
            header("Authorization", "Bearer " + token).
            when().
            get("/orders/"+orderId);
    System.out.println("GetResponse: " + GetResponse.asString());
    assertEquals(GetResponse.getStatusCode(),200);
    assertEquals(GetResponse.jsonPath().getString("id"), orderId);
    assertEquals(GetResponse.jsonPath().getString("customerName"), "Ahmed");

}

}
