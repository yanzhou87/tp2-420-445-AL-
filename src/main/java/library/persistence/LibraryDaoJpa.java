package library.persistence;

import library.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class LibraryDaoJpa implements LibraryDao {
    private UserDao userDao = new UserDaoJpa();
    private ArticleDao articleDao = new ArticleDaoJpa();
    private EmpruntDao empruntDao = new EmpruntDaoJpa();
    private AmendeDao amendeDao = new AmendeDaoJpa();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");

    @Override
    public void saveLibrary(Library library) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(library);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long createLibrary(String name) {
        Library library = Library.builder()
                .name(name)
                .build();
        saveLibrary(library);
        return library.getId();
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
    public void createBook(String title, String author, String date, String type) {
        articleDao.createBook(title,author,date,type);
    }

    @Override
    public void saveArticle(Article article) {
        articleDao.save(article);
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
    public List<Article> findByIdArticle(long id) {
        return articleDao.findByIdArticle(id);
    }

    @Override
    public void createUser(String firstName, String lastName, int age) {
        userDao.createClient(firstName,lastName,age);
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
    public void saveEmprunt(Emprunt emprunt) {
        empruntDao.saveEmprunt(emprunt);
    }

    @Override
    public List<Emprunt> findByNameOfClientEmprunt(long userId) {
        return empruntDao.findByNameOfClientEmprunt(userId);
    }

    @Override
    public void createEmprunt(Client client, Library library, String nameArticle, LocalDateTime date) {
        List<Article> articles = findByNameArticle(nameArticle);
        for (Article article : articles) {
            if (article.getTitle().equals(nameArticle) && !article.isBorrowed()) {
                empruntDao.createEmprunt(client,library,article,date);
                updateIsBorrowde(article);
            }
        }
    }

    private void updateEmprunt(Emprunt emprunt) {
        empruntDao.updateEmprunt(emprunt);
    }

    @Override
    public void returnEmprunts(String firstName, long userId, String articleName) {
        List<Emprunt> emprunts = findByNameOfClientEmprunt(userId);
        for(Emprunt e : emprunts){
            if(e.getClient().getId() == userId){
                if(e.getArticle().getTitle().equals(articleName)){
                    if(e.getArticle() instanceof Book){
                        Duration duration = Duration.between(e.getDate(), LocalDateTime.now());
                        long days = duration.toDays();
                        if(days > 21){
                            long nbday = days - 21;
                            createAmende(e.getClient(),nbday);
                        }
                    }
                    if(e.getArticle() instanceof CD){
                        Duration duration = Duration.between(e.getDate(),LocalDateTime.now());
                        long days = duration.toDays();
                        if(days > 14){
                            long nbday = days - 14;
                            createAmende(e.getClient(),nbday);
                        }
                    }
                    if(e.getArticle() instanceof DVD){
                        Duration duration = Duration.between(e.getDate(),LocalDateTime.now());
                        long days = duration.toDays();
                        if(days > 7){
                            long nbday = days - 7;
                            createAmende(e.getClient(),nbday);
                        }
                    }
                    updateEmprunt(e);
                    articleDao.updateIsBorrowde(e.getArticle());
                }
            }
      }
    }

    @Override
    public void updateIsBorrowde(Article article) {
        articleDao.updateIsBorrowde(article);
    }

    private void createAmende(Client client, long nbday) {
        amendeDao.createAmende(client,nbday);
    }
}
