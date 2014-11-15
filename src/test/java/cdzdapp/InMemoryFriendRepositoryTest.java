package cdzdapp;

import cdzdapp.test.categories.SmallTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(SmallTest.class)
public class InMemoryFriendRepositoryTest {
    @Ignore
    @Test
    public void addFriend() {
        // create two users
        // give one a friend
        // make sure that friend show up only for her and not for the other user
    }
}
