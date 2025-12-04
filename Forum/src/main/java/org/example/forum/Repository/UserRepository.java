package org.example.forum.Repository;
import org.example.forum.Model.User;
import org.example.forum.Model.UserStatus;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<Integer, User> users = new HashMap<>();

    public UserRepository() {
        users.put(1, new User(1, "philia", UserStatus.ADMIN.name()));
        users.put(2, new User(2, "Kaiser", UserStatus.USER.name()));
        users.put(3, new User(3, "blue cat", UserStatus.NEWBIE.name()));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User findById(int id) {
        return users.get(id);
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public void delete(int id) {
        users.remove(id);
    }
}
