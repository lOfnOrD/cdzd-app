package cdzdapp;

import cdzdapp.domain.Friend;
import cdzdapp.domain.User;
import cdzdapp.repository.DbFriendRepository;
import cdzdapp.repository.DbUserRepository;
import cdzdapp.repository.FriendRepository;
import cdzdapp.repository.UserRepository;
import cdzdapp.test.categories.MediumTest;
import cdzdapp.util.Database;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Category(MediumTest.class)
public class DbFriendRepositoryTest {
    @BeforeClass
    public static void setUp() {
        Database.INSTANCE.clean();
        Database.INSTANCE.migrate();
    }

    @Test
    public void addFriend() {
        User marge = new User("Marge");
        User maggie = new User("Maggie");

        UserRepository userRepository = DbUserRepository.INSTANCE;
        userRepository.addUser(marge);
        userRepository.addUser(maggie);

        Friend barney = new Friend(marge, "Barney", "Gumble");

        FriendRepository friendRepository = DbFriendRepository.INSTANCE;
        friendRepository.addFriend(barney);

        assertTrue(friendRepository.getFriendsForUser(marge).contains(barney));
        assertFalse(friendRepository.getFriendsForUser(maggie).contains(barney));
    }
}
