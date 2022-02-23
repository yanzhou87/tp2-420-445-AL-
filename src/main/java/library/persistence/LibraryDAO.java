package library.persistence;

import library.model.Article;

public interface LibraryDAO {

    public void save(Article articles);

    public Article getArticle(int articleId);
}
