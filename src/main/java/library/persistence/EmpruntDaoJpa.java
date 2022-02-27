package library.persistence;

import library.model.Emprunt;
import library.model.LibraryUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmpruntDaoJpa implements EmpruntDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");
    UserDao userDao = new UserDaoJpa();
    @Override
    public List<Emprunt> findByNameOfClientEmprunt(String userName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Emprunt> query = em.createQuery("select e from Emprunt e where client.firstName like :userNameToSearch",Emprunt.class);
        query.setParameter("userNameToSearch", userName);

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
    public void deleteEmprunt(Emprunt emprunt) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.remove(emprunt);

        em.getTransaction().commit();
        em.close();
    }
}
