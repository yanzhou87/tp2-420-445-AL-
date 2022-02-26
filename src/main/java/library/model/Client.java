package library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("client")
public class Client extends LibraryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "client")
    private List<Emprunt> emprunts;

    public void borrow(){

    }

    public void returnArticle(){

    }

    public void toPay(){}
}
