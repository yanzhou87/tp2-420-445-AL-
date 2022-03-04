package library.persistence;

import library.model.Emprunt;

import java.util.List;

public interface EmpruntDao {


    List<Emprunt> findByNameOfClientEmprunt(long userId);

    void saveEmprunt(Emprunt emprunt);

    void updateEmprunt(Emprunt emprunt);
}
