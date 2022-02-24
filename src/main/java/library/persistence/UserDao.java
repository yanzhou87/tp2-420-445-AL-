package library.persistence;

import library.model.LibraryUser;

import java.util.List;

public interface UserDao {
    void save(LibraryUser user);

    List<LibraryUser> findByName(String name);
}
