package library.persistence;

import library.model.Article;
import library.model.LibraryUser;

import java.util.List;

public interface LibraryDao {

    void saveArticle(Article article);

    void saveUser(LibraryUser user);

    List<Article> findByNameArticle(String article);

    Article getArticleById(long id);

    List<LibraryUser> findByNameUser(String name);

    LibraryUser getUserById(long id);

}