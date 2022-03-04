package library.persistence;

import library.model.LibraryUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoJpa implements UserDao {
     private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");
    @Override
    public void save(LibraryUser user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<LibraryUser> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<LibraryUser> query = em.createQuery("select u from LibraryUser u where firstName like :nameToSearch", LibraryUser.class );
        query.setParameter("nameToSearch","%" + name + "%");

        final List<LibraryUser> users = query.getResultList();

        em.getTransaction().commit();
        em.close();

        return users;
    }

    @Override
    public LibraryUser findByIdUser(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<LibraryUser> query = em.createQuery("select u from LibraryUser u where id = id",LibraryUser.class);

        final List<LibraryUser> users = query.getResultList();

        em.getTransaction().commit();
        em.close();

        for(LibraryUser user : users){
            if(user.getId() == id){
               return user;
            }
        }
        return null;
    }
}
