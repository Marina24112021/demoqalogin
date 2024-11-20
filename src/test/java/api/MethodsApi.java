package api;

import data.LoginData;
import models.*;

import java.util.List;

import static data.AuthorizedData.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.CodeDemoQASpec.*;


public class MethodsApi {
     public static LoginResponseModel userAuthorizationApi(){
         LoginRequestModel request = new LoginRequestModel();
         LoginData userData = new LoginData();
         request.setUserName(userData.getUserName());
         request.setPassword(userData.getPassword());

         LoginResponseModel response = step("Login Response ", ()-> given(requestSpec)
                .body(request)

                .when()
                .post("/Account/v1/Login")

                .then()
                .spec(successfulResponse200Spec)
                .extract().as(LoginResponseModel.class));

        return response;
    }

   public static void deleteAllBooksApi(){
       step("Request Delete ", ()-> given()
                .header("Authorization", "Bearer " + USER_TOKEN)
                .queryParam("UserId", USER_ID)

                .when()
                .delete("/BookStore/v1/Books")

                .then()
                .spec(successfulResponse204Spec));
    }

    public static void addBookToCardApi(String isbn){
        AddBooksToCardModel request = new AddBooksToCardModel();
        Isbn_Model isbnModel = new Isbn_Model();
        isbnModel.setIsbn(isbn);
        request.setUserId(USER_ID);
        request.setCollectionOfIsbns(List.of(isbnModel));
        step("Request", ()-> given(requestSpec)
                .header("Authorization", "Bearer " + USER_TOKEN)
                .body(request)

                .when()
                .post("/BookStore/v1/Books")

                .then()
                .spec(successfulResponse201Spec));
    }

    public static  GetCollectionOfAllBooksModel getAllCollectionOfBooksFromCardApi(){
        GetCollectionOfAllBooksModel response =
                step("Response", ()-> given(requestSpec)
                        .header("Authorization", "Bearer " + USER_TOKEN)
                        .queryParam("UserId", USER_ID)

                        .when()
                        .get("/Account/v1/User/" + USER_ID)

                        .then()
                        .spec(successfulResponse200Spec)
                        .extract().as(GetCollectionOfAllBooksModel.class));
        return response;
    }
}
