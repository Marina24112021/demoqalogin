package helpers.extensions;

import api.MethodsApi;
import data.AuthorizedData;
import data.LoginData;
import models.LoginResponseModel;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        LoginData loginData = new LoginData();
        LoginResponseModel cookies = MethodsApi.userAuthorizationApi();

        AuthorizedData.USER_ID = cookies.getUserId();
        AuthorizedData.EXPIRES = cookies.getExpires();
        AuthorizedData.USER_TOKEN = cookies.getToken();

        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", cookies.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("expires", cookies.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("token", cookies.getToken()));

        open("/profile");
        $("#userName-value").shouldHave(text(loginData.getUserName()));

    }
}
