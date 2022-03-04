package library.persistence;

import library.model.Emprunt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmpruntDaoJpa implements EmpruntDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");
    UserDao userDao = new UserDaoJpa();
    @Override
    public List<Emprunt> findByNameOfClientEmprunt(long userId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Emprunt> query = em.createQuery("select e from Emprunt e where client.id = :userIdToSearch",Emprunt.class);
        query.setParameter("userIdToSearch", userId);

        List<Emprunt> emprunts = query.getResultList();

        return emprunts;
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
