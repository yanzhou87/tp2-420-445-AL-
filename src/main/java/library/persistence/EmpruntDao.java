package library.persistence;

import library.model.Article;
import library.model.Client;
import library.model.Emprunt;
import library.model.Library;

import java.time.LocalDateTime;
import java.util.List;

public interface EmpruntDao {


    List<Emprunt> findByNameOfClientEmprunt(long userId);

    void saveEmprunt(Emprunt emprunt);

    void updateEmprunt(Emprunt emprunt);

    long createEmprunt(Client client, Library library, Article article, LocalDateTime date);
}
