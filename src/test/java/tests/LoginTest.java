package tests;


import api.MethodsApi;
import helpers.extensions.WithLogin;
import models.GetCollectionOfAllBooksModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("restAPI")
public class LoginTest extends TestBase{
    @Test
    @WithLogin
    @DisplayName("Using API and UI to delete books and check the empty collection")
    void successfulDeleteBookTest() {
        step("Delete all books in collection", ()-> MethodsApi.deleteAllBooksApi());
        step("Add book about git to collection", ()-> MethodsApi.addBookToCardApi("9781449325862"));

        step("Open page using selenoid", ()-> ProfilePage.openPageFromUI());
        step("Delete added book from collection", ()-> ProfilePage.deleteOneBookFromUI());

        step("Open page using selenoid ", ()-> ProfilePage.openPageFromUI());
        step("Check that collection is empty from UI", ()-> ProfilePage.checkDeleteBookWithUI());

        GetCollectionOfAllBooksModel response =
                step("Check that collection is empty from API ", () ->  MethodsApi.getAllCollectionOfBooksFromCardApi());
       assertThat(response.getBooks()).isEmpty();
    }
}
