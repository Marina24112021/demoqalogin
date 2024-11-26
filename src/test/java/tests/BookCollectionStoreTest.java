package tests;

import api.Books.MethodsApi;
import api.models.GetCollectionOfAllBooksModel;
import helpers.extensions.WithLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("restapi")
public class BookCollectionStoreTest extends TestBase {
    @Test
    @WithLogin
    @DisplayName("Using API and UI to delete books and check the empty collection")
    void successfulDeleteBookTest() {
        MethodsApi.deleteAllBooksApi();
        MethodsApi.addBookToCardApi("9781449325862");

        ProfilePage.openPageFromUI();
        ProfilePage.deleteOneBookFromUI();
        ProfilePage.openPageFromUI();
        ProfilePage.checkDeleteBookWithUI();

        GetCollectionOfAllBooksModel response = MethodsApi.getAllCollectionOfBooksFromCardApi();
        assertThat(response.getBooks()).isEmpty();
    }
}
