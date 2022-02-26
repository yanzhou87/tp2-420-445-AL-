package library.model;

import library.persistence.UserDao;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @OneToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article articles;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;
    private LocalDateTime date;


}
