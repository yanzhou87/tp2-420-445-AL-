package library.persistence;

import library.model.Article;

import java.util.List;

public interface ArticleDao {

    void save(Article article);

    List<Article> findByNameArticle(String article);

    Article findByIdArticle(long id);

    void updateIsBorrowde(Article article);

    long createBook(String title, String author, String date, String type);
}
