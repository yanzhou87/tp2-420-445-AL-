package library.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(generator = "emprunt_seq")
    private long id;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @OneToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;
    private LocalDateTime date;
    private boolean isReturn = false;


}
