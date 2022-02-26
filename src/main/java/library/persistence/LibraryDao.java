package library.persistence;

import library.model.*;

import java.util.List;

public interface LibraryDao {

    void saveArticle(Article article);

    void saveUser(LibraryUser user);

    List<Article> findByNameArticle(String article);

    Article getArticleById(long id);

    List<LibraryUser> findByNameUser(String name);

    LibraryUser getUserById(long id);

    void saveLibrary(Library library);

    List<Library> findByNameLibrary(String name);

    List<LibraryUser> findByIdUser(long id);

    List<Article> findByIdArticle(long id);

    void saveEmprunt(Emprunt emprunt);

    List<Exemplaire> findByNameArticleExemplaires(String nameArticle);

    List<Emprunt> findByNameOfClientEmprunt(String userName);
}
