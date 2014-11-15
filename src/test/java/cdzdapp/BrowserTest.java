package cdzdapp;

import cdzdapp.test.api.FriendsPage;
import cdzdapp.test.api.LoginPage;
import cdzdapp.test.categories.LargeTest;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Category(LargeTest.class)
public class BrowserTest {
    @BeforeClass
    public static void setUpClass() {
        Main.start();
    }

    @AfterClass
    public static void tearDownClass() {
        Main.stop();
    }

    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
    }

    @After
    public void tearDown() {
        webClient.closeAllWindows();
    }

    @Test
    public void bartsFriends() throws Exception {
        LoginPage loginPage = new LoginPage((HtmlPage) webClient.getPage("http://localhost:" + Main.HTTP_SERVER_PORT));
        assertTrue(loginPage.isLoaded());

        FriendsPage friendsPage = loginPage.login("Bart");
        assertTrue(friendsPage.isLoaded());
        assertEquals("Bart", friendsPage.getName());
        assertEquals(3, friendsPage.getFriendsCount());

        loginPage = friendsPage.logout();
        assertTrue(loginPage.isLoaded());
    }

    @Ignore
    @Test
    public void lisasFriend() throws Exception {
        // log in as lisa
        // check that she has no friends
        // create a new friend and check she exists
        // logout
        // log in again and check her friend is still there
    }
}
