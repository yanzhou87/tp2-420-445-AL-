package library.persistence;

import library.model.Article;

import java.util.List;

public interface ArticleDao {

    void save(Article article);

    List<Article> findByName(String article);
}
