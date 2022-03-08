package library.persistence;

import library.model.LibraryUser;

import java.util.List;

public interface UserDao {
    void createClient(String firstName, String lastName, int age);

    void save(LibraryUser user);

    List<LibraryUser> findByName(String name);

    LibraryUser findByIdUser(long id);
}
