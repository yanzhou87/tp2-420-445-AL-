package library.persistence;

import library.model.Article;
import library.model.Library;
import library.model.LibraryUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LibraryDaoJpa implements LibraryDao {
    private UserDao userDao = new UserDaoJpa();
    private ArticleDao articleDao = new ArticleDaoJpa();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");
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
        return articleDao.findByNameArticle(article);
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

    @Override
    public void saveLibrary(Library library) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(library);

        em.getTransaction().commit();
        em.close();
    }
}
