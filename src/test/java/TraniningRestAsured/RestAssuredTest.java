package TraniningRestAsured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class RestAssuredTest {

    @Test
    public void getData(){
        String endpoint = "https://reqres.in/api/users?page=2";
        given().
                when().get(endpoint)
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("data.id[0]",equalTo(7))
                .body("data.email[0]",equalTo("michael.lawson@reqres.in"))
                .body("data.first_name[0]",equalTo("Michael"))
                .body("data.last_name[0]",equalTo("Lawson"));

    }

    @Test
    public void assertionBody(){
        String endpoint = "https://reqres.in/api/users?page=2";
        given().
                when().get(endpoint)
                .then()
                .log().body()
                .log().headers()
                .assertThat()
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .statusCode(200)
                .body("data.size()",equalTo(6))
                .body("data.size()",greaterThan(0))
                .body("data.id",everyItem(notNullValue()))
                .body("data.email",everyItem(notNullValue()));

    }

    @Test
    public void getData1(){
        // Using query parameter
        String endpoint = "https://reqres.in/api/users";
        var response=given().queryParam("page",1).
                when().get(endpoint)
                .then();
        response.log().body();
    }

    @Test
    public void createData(){
        String endpoint = "https://reqres.in/api/users";
        String body = "{\n" +
                "    name: morpheus,\n" +
                "    job: leader\n" +
                "}";

        var response=given().body(body)
                .when().post(endpoint)
                .then();
        response.log().body();
        response.statusCode(201);
    }
    @Test
    public void updateData(){
        String endpoint = "https://reqres.in/api/users/2";
        String body = "{\n" +
                "    \"name\": \"Akash\",\n" +
                "    \"job\": \"Test\"\n" +
                "}";

        var response=given().body(body)
                .when().put(endpoint)
                .then();
        response.log().body();
        response.assertThat().statusCode(200);
    }

    @Test
    public void deleteData(){
        String endpoint = "https://reqres.in/api/users/2";

        given()
                .when().delete(endpoint)
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }

    @Test
    public void createSerializedProduct(){
        String endpoint = "https://reqres.in/api/users";
        ProductData data = new ProductData("akash","QA");

        var response=given().contentType("application/json").body(data)
                .when().post(endpoint)
                .then();
        response.log().body();
        response.log().all();
        response.statusCode(201);

    }

   // @Test
    public void createDeserializedProduct(){
        String endpoint = "https://reqres.in/api/users";
        ProductData expectedProduct = new ProductData(1,"george.bluth@reqres.in","George","Bluth","https://reqres.in/img/faces/1-image.jpg");
      ProductData actualProduct=
              given()
                      .when().get(endpoint).as(ProductData.class);

     // assertThat(actualProduct, samePropertyValuesAs(expectedProduct));

    }

}
