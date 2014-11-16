package cdzdapp.repository;

import cdzdapp.domain.User;
import cdzdapp.repository.DbUserRepository;
import cdzdapp.repository.UserRepository;
import cdzdapp.test.categories.MediumTest;
import cdzdapp.util.Database;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@Category(MediumTest.class)
public class DbUserRepositoryTest {

    private static final String MR_TEST = "Mr. Test";

    @BeforeClass
    public static void setUp() {
        Database.INSTANCE.clean();
        Database.INSTANCE.migrate();
    }

    @Test
    public void addUser() {
        User mrTest = new User(MR_TEST);

        UserRepository repository = DbUserRepository.INSTANCE;
        assertNull(repository.getUserByName(MR_TEST));
        repository.addUser(mrTest);
        assertEquals(mrTest, repository.getUserByName(MR_TEST));
    }
}
