package library.persistence;

import library.model.Article;
import library.model.LibraryUser;

import java.util.List;

public class LibraryDaoJpa implements LibraryDao {
    private UserDao userDao = new UserDaoJpa();
    private ArticleDao articleDao = new ArticleDaoJpa();
    @Override
    public void saveArticle(Article article) {
          articleDao.save(article);
    }

    @Override
    public void saveUser(LibraryUser user) {
         userDao.save(user);
    }

    @Override
    public List<Article> findByNameArticle(String article) {
        return articleDao.findByName(article);
    }

    @Override
    public Article getArticleById(long id) {
        return null;
    }

    @Override
    public List<LibraryUser> findByNameUser(String name) {
        return userDao.findByName(name);
    }

    @Override
    public LibraryUser getUserById(long id) {
        return null;
    }
}
