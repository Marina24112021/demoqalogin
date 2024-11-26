package api.Books;

import api.Account.Authorization;
import api.models.AddBooksToCardModel;
import api.models.GetCollectionOfAllBooksModel;
import api.models.IsbnModel;
import io.qameta.allure.Step;

import java.util.List;

import static io.restassured.RestAssured.given;
import static specs.CodeDemoQASpec.*;

public class MethodsApi {
    @Step("Delete all books in collection")
    public static void deleteAllBooksApi() {
        given()
                .header("Authorization", "Bearer " +
                        Authorization.userAuthorizationApi().getToken())
                .queryParam("UserId", Authorization.userAuthorizationApi().getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(successfulResponse204Spec);
    }

    @Step("Add book about git to collection")
    public static void addBookToCardApi(String isbn) {
        IsbnModel isbnModel = new IsbnModel(isbn);
        AddBooksToCardModel request = new AddBooksToCardModel(Authorization.userAuthorizationApi().getUserId(), List.of(isbnModel));
        given(requestSpec)
                .header("Authorization", "Bearer " + Authorization.userAuthorizationApi().getToken())
                .body(request)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(successfulResponse201Spec);
    }

    @Step("Check that collection is empty from API ")
    public static GetCollectionOfAllBooksModel getAllCollectionOfBooksFromCardApi() {
        return given(requestSpec)
                .header("Authorization", "Bearer " + Authorization.userAuthorizationApi().getToken())
                .queryParam("UserId", Authorization.userAuthorizationApi().getUserId())
                .when()
                .get("/Account/v1/User/" + Authorization.userAuthorizationApi().getUserId())
                .then()
                .spec(successfulResponse200Spec)
                .extract().as(GetCollectionOfAllBooksModel.class);
    }
}
