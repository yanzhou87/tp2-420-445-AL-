package library.persistence;

import library.model.Amende;

import java.util.List;

public interface AmendeDao {

    void saveAmende(AmendeDao amende);

    List<Amende> findByClientName(String nameOfClient);
}
