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
    public Library findByNameLibrary(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Library> query = em.createQuery("select l from Library l where name like :nameToSearch ",Library.class);
        query.setParameter("nameToSearch", "%" + name + "%");

        List<Library> libraries = query.getResultList();

        em.getTransaction().commit();
        em.close();

        for(Library library : libraries){
            if(library.getName().equals(name)){
                return library;
            }
        }

        return null;
    }

    @Override
    public LibraryUser findByIdUser(long id) {
        return userDao.findByIdUser(id);
    }

    @Override
    public List<Article> findByIdArticle(long id) {
        return articleDao.findByIdArticle(id);
    }

    @Override
    public void saveEmprunt(Emprunt emprunt) {
        empruntDao.saveEmprunt(emprunt);
    }

    @Override
    public List<Exemplaire> findByNameArticleExemplaires(String nameArticle) {
        return articleDao.findByNameArticleExemplaires(nameArticle);
    }

    @Override
    public List<Emprunt> findByNameOfClientEmprunt(String userName) {
        return empruntDao.findByNameOfClientEmprunt(userName);
    }

    @Override
    public boolean isValidForExemplaire(String name) {
        return articleDao.isValidForExemplaire(name);
    }

    @Override
    public void deleteExemplaire(Exemplaire exemplaire) {
        articleDao.deleteExemplaire(exemplaire);
    }

    @Override
    public void returnEmprunts(String firstName, long id, String articleName) {
        List<Emprunt> emprunts = findByNameOfClientEmprunt(firstName);
        for(Emprunt e : emprunts){
            if(e.getClient().getId() == id){
                if(e.getExemplaire().getTitle().equals(articleName)){
                    if(e.getExemplaire().getArticle() instanceof Book){
                        Duration duration = Duration.between(e.getDate(), LocalDateTime.now());
                        long days = duration.toDays();
                        if(days > 21){
                            long nbday = days - 21;
                            createAmende(e.getClient(),nbday);
                        }
                        deleteEmprunt(e);
                        articleDao.save(e.getExemplaire());
                    }
                    if(e.getExemplaire().getArticle() instanceof CD){
                        Duration duration = Duration.between(e.getDate(),LocalDateTime.now());
                        long days = duration.toDays();
                        if(days > 14){
                            long nbday = days - 14;
                            createAmende(e.getClient(),nbday);
                        }
                        deleteEmprunt(e);
                        articleDao.save(e.getExemplaire());
                    }
                    if(e.getExemplaire().getArticle() instanceof DVD){
                        Duration duration = Duration.between(e.getDate(),LocalDateTime.now());
                        long days = duration.toDays();
                        if(days > 7){
                            long nbday = days - 7;
                            createAmende(e.getClient(),nbday);
                        }
                        deleteEmprunt(e);
                        articleDao.save(e.getExemplaire());
                    }
                }
            }
        }
    }
    private void createAmende(Client client, long nbday) {
        Amende amende = new Amende();
        amende.setClient(client);
        amende.setSommeAmende(nbday * amende.getAmendeForDay());
        saveAmende(amende);
    }

}
