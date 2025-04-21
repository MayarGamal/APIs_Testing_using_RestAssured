import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GETAPITests{

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
    }
    @Test
    public void GetStatus(){
        given().
                when().
                get("/status").
                then().
                statusCode(200).
                log().body();


    }
    @Test
    public void GetBooks(){
       given().
               when().
               get("/books").
               then().
               statusCode(200).
               log().body();


    }
    @Test
    public void GetSingleBook(){
        given().
                when().
                get("/books/1").
                then().
                statusCode(200).
                log().body();


    }
}


