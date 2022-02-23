package library.persistence;

import library.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> findByName(String name);
}
