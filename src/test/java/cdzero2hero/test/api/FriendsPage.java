package cdzero2hero.test.api;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class FriendsPage {
    private final HtmlPage htmlPage;

    public FriendsPage(HtmlPage htmlPage) {
        this.htmlPage = htmlPage;
    }

    public boolean isLoaded() {
        return "friends".equals(htmlPage.getBody().getId());
    }

    public String getName() {
        return htmlPage.getElementById("name").asText();
    }

    public LoginPage logout() throws IOException {
        HtmlAnchor logout = htmlPage.getAnchorByHref("/logout");
        HtmlPage newPage = logout.click();
        return new LoginPage(newPage);
    }

    public int getFriendsCount() {
        return htmlPage.getByXPath("//tr[@class='friend']").size();
    }
}
