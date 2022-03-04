package library.persistence;

import library.model.Article;

import java.util.List;

public interface ArticleDao {

    void save(Article article);

    List<Article> findByNameArticle(String article);

    List<Article> findByIdArticle(long id);

    void updateIsBorrowde(Article article);

//    List<ExemplaireBook> findByNameExemplaires(String nameArticle);
//
//    boolean isValidForExemplaire(String name);
//
//    void updatePossibleExemplaire(ExemplaireBook e);
}
