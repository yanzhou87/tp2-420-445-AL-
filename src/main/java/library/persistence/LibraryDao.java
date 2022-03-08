package library.persistence;

import library.model.*;

import java.time.LocalDateTime;
import java.util.List;

public interface LibraryDao {


    List<Article> findByNameArticle(String article);

    Article getArticleById(long id);

    List<LibraryUser> findByNameUser(String name);

    LibraryUser getUserById(long id);




    LibraryUser findByIdUser(long id);

    Article findByIdArticle(long id);

    void saveEmprunt(Emprunt emprunt);

    Emprunt findByNameOfClientEmprunt(long userId);

    void returnEmprunts(String firstName, long id, String articleName);

    void updateIsBorrowde(Article article);

    long createUser(String firstName, String lastName, int age);

    long createEmprunt(Client client, Library library, String nameArticle, LocalDateTime date);

    long createBook(String title, String author, String date, String type);

    long createLibrary(String name);

    void saveLibrary(Library library);

    Library findLibraryById(long libraryId);

    List<Library> findByNameLibrary(String name);
}
