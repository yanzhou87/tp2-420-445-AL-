package library.persistence;

import library.model.Article;
import library.model.Client;
import library.model.Emprunt;
import library.model.Library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;

public class EmpruntDaoJpa implements EmpruntDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");

    @Override
    public long createEmprunt(Client client, Library library,Article article, LocalDateTime date) {

        Emprunt emprunt = Emprunt.builder()
                .client(client)
                .library(library)
                .article(article)
                .date(date)
                .build();
        saveEmprunt(emprunt);

        return emprunt.getId();
    }
    @Override
    public Emprunt findByNameOfClientEmprunt(long userId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Emprunt> query = em.createQuery("select e from Emprunt e where client.id = :userIdToSearch",Emprunt.class);
        query.setParameter("userIdToSearch", userId);

        Emprunt emprunt = query.getSingleResult();

        return emprunt;
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
    public void updateEmprunt(Emprunt emprunt) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Emprunt emprunt1 = em.find(Emprunt.class, emprunt.getId());

        emprunt1.setReturn(!emprunt1.isReturn());

        em.merge(emprunt1);

        em.getTransaction().commit();
        em.close();
    }
}
