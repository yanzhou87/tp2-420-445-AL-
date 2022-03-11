package library.persistence;

import library.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class LibraryDaoJpa implements LibraryDao {
    private UserDao userDao = new UserDaoJpa();
    private ArticleDao articleDao = new ArticleDaoJpa();
    private EmpruntDao empruntDao = new EmpruntDaoJpa();
    private AmendeDao amendeDao = new AmendeDaoJpa();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");

    @Override
    public long createLibrary(String name) {
        Library library = Library.builder()
                .name(name)
                .build();
        saveLibrary(library);
        return library.getId();
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
    public Library findLibraryById(long libraryId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Library library = em.find(Library.class, libraryId);

        em.getTransaction().commit();
        em.close();

        return library;
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
    public long createBook(String title, String author, String date, String type) {
        return articleDao.createBook(title,author,date,type);
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
    public Article findByIdArticle(long id) {
        return articleDao.findByIdArticle(id);
    }

    @Override
    public long createUser(String firstName, String lastName, int age) {
        return userDao.createClient(firstName,lastName,age);
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
    public LibraryUser findByIdUser(long id) {
        return userDao.findByIdUser(id);
    }

    @Override
    public long createEmprunt(Client client, Library library, String nameArticle, LocalDateTime date) {
        List<Article> articles = findByNameArticle(nameArticle);
        long empruntId = 0;
        for (Article article : articles) {
            if (article.getTitle().equals(nameArticle) && !article.isBorrowed()) {
                empruntId = empruntDao.createEmprunt(client,library,article,date);
                updateIsBorrowde(article);
            }
        }
        return empruntId;
    }

    @Override
    public void saveEmprunt(Emprunt emprunt) {
        empruntDao.saveEmprunt(emprunt);
    }

    @Override
    public Emprunt findByNameOfClientEmprunt(long userId) {
        return empruntDao.findByNameOfClientEmprunt(userId);
    }

    private void updateEmprunt(Emprunt emprunt) {
        empruntDao.updateEmprunt(emprunt);
    }

    @Override
    public void returnEmprunts(String firstName, long userId, String articleName) {
        Emprunt emprunt = findByNameOfClientEmprunt(userId);

            if(emprunt.getClient().getId() == userId){
                if(emprunt.getArticle().getTitle().equals(articleName)){
                    updateEmprunt(emprunt);
                    articleDao.updateIsBorrowde(emprunt.getArticle());
                }
            }

    }

    @Override
    public void updateIsBorrowde(Article article) {
        articleDao.updateIsBorrowde(article);
    }

    private long createAmende(Client client, long nbday) {
        return amendeDao.createAmende(client,nbday);
    }
}
