package cdzdapp.repository;

import cdzdapp.domain.Friend;
import cdzdapp.domain.User;

import java.util.List;

public interface FriendRepository {
    List<Friend> getFriendsForUser(User user);

    void addFriend(Friend newFriend);

    void deleteFriend(Integer userId, Integer friendId);
}
