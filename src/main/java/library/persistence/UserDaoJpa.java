package library.persistence;

import library.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoJpa implements UserDao {
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");
    @Override
    public void save(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<User> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<User> query = em.createQuery("select u from User u where firstName like :nameToSearch", User.class );
        query.setParameter("nameToSearch","%" + name + "%");

        final List<User> users = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return users;
    }
}
