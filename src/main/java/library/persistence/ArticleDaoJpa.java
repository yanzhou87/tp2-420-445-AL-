package library.persistence;

import library.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ArticleDaoJpa implements ArticleDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");
    @Override
    public void save(Article article) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(article);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Article> findByNameArticle(String article) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Article> query = em.createQuery("select a from Article a  where title like :nameToSearch " +
                "or author like :nameToSearch or yearPublication like :nameToSearch or typeArticle like :nameToSearch"  , Article.class );
        query.setParameter("nameToSearch","%" + article + "%");

        final List<Article> articles = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return articles;
    }

    @Override
    public List<Article> findByIdArticle(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Article> query = em.createQuery("select a from Article a where id = id",Article.class);

        final List<Article> articles = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return articles;
    }

    @Override
    public void updateIsBorrowde(Article article) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Article article1 = em.find(Article.class, article.getId());

        article1.setBorrowed(!article1.isBorrowed());
        em.merge(article1);

        em.getTransaction().commit();
        em.close();

    }

//    @Override
//    public List<ExemplaireBook> findByNameExemplaires(String nameExemplaire) {
//
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        final TypedQuery<Exemplaire> query = em.createQuery("select e from Exemplaire e where id = id",Exemplaire.class);
//
//        final List<Exemplaire> exemplaires = query.getResultList();
//
//
//        em.getTransaction().commit();
//        em.close();
//
//        return exemplaireList;
//    }

//    @Override
//    public boolean isValidForExemplaire(String name) {
//
//        List<ExemplaireBook> exemplaires = findByNameExemplaires(name);
//
//       if(!exemplaires.isEmpty()){
//           return true;
//       }
//        return false;
//    }

//    @Override
//    public void updatePossibleExemplaire(ExemplaireBook e) {
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        ExemplaireBook exemplaire = em.find(ExemplaireBook.class, e.getId());
//
//        exemplaire.setIsEmprunt(!exemplaire.isIsEmprunt());
//        em.merge(exemplaire);
//
//        em.getTransaction().commit();
//        em.close();
//    }


}
