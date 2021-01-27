package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Pet;

public class PetService extends ServicesBase {


    public Response postPet(Pet pet) {
        return RestAssured.given().contentType(ContentType.JSON)
                .spec(getRequestSpec())
                .body(convertObjectToJson(pet, new ObjectMapper()))
                .when().log().all().post("/pet").then().log().all().extract().response();
    }


    public Response getPet(int id) {
        return RestAssured.given().contentType(ContentType.JSON)
                .spec(getRequestSpec())
                .when().log().all().get("/pet/"+ id).then().log().all().extract().response();

    }

    public Response putPet(Pet pet) {
        return RestAssured.given().contentType(ContentType.JSON)
                .spec(getRequestSpec())
                .body(convertObjectToJson(pet, new ObjectMapper()))
                .when().log().all().put("/pet/").then().log().all().extract().response();


    }
}
