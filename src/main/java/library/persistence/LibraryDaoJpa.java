package library.persistence;

import library.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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

    @Override
    public List<Library> findByNameLibrary(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Library> query = em.createQuery("select l from Library l where name like :nameToSearch ",Library.class);
        query.setParameter("nameToSearch", "%" + name + "%");

        List<Library> libraries = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return libraries;
    }

    @Override
    public List<LibraryUser> findByIdUser(long id) {
        return userDao.findByIdUser(id);
    }

    @Override
    public List<Article> findByIdArticle(long id) {
        return articleDao.findByIdArticle(id);
    }

    @Override
    public void saveEmprunt(Emprunt emprunt) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

       em.persist(emprunt);

       em.getTransaction().commit();
       em.close();
    }

    @Override
    public List<Exemplaire> findByNameArticleExemplaires(String nameArticle) {
        return articleDao.findByNameArticleExemplaires(nameArticle);
    }
}
