package library.persistence;

import library.model.Article;
import library.model.ExemplaireBook;

import java.util.List;

public interface ArticleDao {

    void save(Article article);

    List<Article> findByNameArticle(String article);

    List<Article> findByIdArticle(long id);

    List<ExemplaireBook> findByNameArticleExemplaires(String nameArticle);

    boolean isValidForExemplaire(String name);

    void updatePossibleExemplaire(ExemplaireBook e);
}
