package library.persistence;

import library.model.*;

import java.time.LocalDateTime;
import java.util.List;

public interface LibraryDao {

    void saveArticle(Article article);


    List<Article> findByNameArticle(String article);

    Article getArticleById(long id);

    List<LibraryUser> findByNameUser(String name);

    LibraryUser getUserById(long id);

    void saveLibrary(Library library);

    List<Library> findByNameLibrary(String name);

    LibraryUser findByIdUser(long id);

    List<Article> findByIdArticle(long id);

    void saveEmprunt(Emprunt emprunt);

    List<Emprunt> findByNameOfClientEmprunt(long userId);

    void returnEmprunts(String firstName, long id, String articleName);

    void updateIsBorrowde(Article article);

    void createUser(String firstName, String lastName, int age);

    void createEmprunt(Client client, Library library, String nameArticle, LocalDateTime date);

    void createBook(String title, String author, String date, String type);

    long createLibrary(String name);

    Library findLibraryById(long libraryId);
}
