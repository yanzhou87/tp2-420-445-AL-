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

    Library findByNameLibrary(String name);

    LibraryUser findByIdUser(long id);

    List<Article> findByIdArticle(long id);

    void saveEmprunt(Emprunt emprunt);

//    List<ExemplaireBook> findByNameArticleExemplaires(String nameArticle);

    List<Emprunt> findByNameOfClientEmprunt(long userId);

 //   boolean isValidForExemplaire(String name);


    void returnEmprunts(String firstName, long id, String articleName);

    void updateIsBorrowde(Article article);

//    void updatePossibleExemplaire(ExemplaireBook e);
//
//    void saveExemplaire(ExemplaireBook exemplaireBook);
}
