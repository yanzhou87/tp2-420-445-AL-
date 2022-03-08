package library.persistence;

import library.model.Amende;
import library.model.Client;

import java.util.List;

public interface AmendeDao {

    void saveAmende(Amende amende);

    List<Amende> findByClientName(String nameOfClient);

    long createAmende(Client client, long nbday);

}
