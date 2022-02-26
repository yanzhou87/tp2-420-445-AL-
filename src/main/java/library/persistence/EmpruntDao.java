package library.persistence;

import library.model.Emprunt;

import java.util.List;

public interface EmpruntDao {


    List<Emprunt> findByNameOfClientEmprunt(String userName);

    void saveEmprunt(Emprunt emprunt);
}
