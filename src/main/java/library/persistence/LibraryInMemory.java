package library.persistence;

import library.model.Article;

import java.util.HashMap;
import java.util.Map;

public class LibraryInMemory implements LibraryDAO {
    Map<Integer, Article> articleMap = new HashMap<>();

    @Override
    public void save(Article article) {

            articleMap.put(article.getId(),article);

    }

    @Override
    public Article getArticle(int articleId) {
        return articleMap.get(articleId);
    }
}
