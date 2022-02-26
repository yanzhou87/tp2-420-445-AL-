package library.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "LibraryUser_type", discriminatorType = DiscriminatorType.STRING)
@EqualsAndHashCode(exclude = "article")
public class Client extends LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "client",  fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Emprunt> emprunts;

    public void borrow(){

    }

    public void returnArticle(){

    }

    public void toPay(){}
}
