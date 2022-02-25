package library.persistence;

import library.model.Article;
import library.model.Book;

import java.util.List;

public interface ArticleDao {

    void save(Article article);

    List<Article> findByNameArticle(String article);

  //  List<Book> findByNameBook(String name);
}
