package library.persistence;

import library.model.Amende;
import library.model.Article;
import library.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AmendeDaoJpa implements AmendeDao{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2.exe");
    public void saveAmende(AmendeDao amende) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(amende);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Amende> findByClientName(String nameOfClient) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Amende> query = em.createQuery("select a from Amende a  where client.firstName like :nameToSearch " , Amende.class );
        query.setParameter("nameToSearch","%" + nameOfClient + "%");

        final List<Amende> amendes = query.getResultList();

        em.getTransaction().commit();
        em.close();
        return amendes;
    }


}
