package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePage {
    @Step("Open page with selenoid")
    public static void openPageFromUI() {
        open("/profile");
    }

    @Step("Delete added book from collection")
    public static void deleteOneBookFromUI() {
        $("#delete-record-undefined").click();
        $("#closeSmallModal-ok").click();
    }

    @Step("Check collection is empty with UI")
    public static void checkDeleteBookWithUI() {
        $("#see-book-Git Pocket Guide").shouldNotBe(visible);
    }
}
