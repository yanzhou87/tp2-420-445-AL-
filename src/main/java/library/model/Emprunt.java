package library.model;

import library.persistence.UserDao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToMany(mappedBy = "emprunt")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;
    private LocalDateTime date;

    public Emprunt(Client client, Library library, LocalDateTime date) {
        this.client = client;
        this.library = library;
        this.date = date;
    }

    public Emprunt() {
    }
}
