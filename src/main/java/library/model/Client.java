package library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("client")
public class Client extends LibraryUser {

    @ManyToOne
    @JoinColumn(name = "EMPRUNT_ID")
    private Emprunt emprunt;


    public void borrow(){

    }

    public void returnArticle(){

    }

    public void toPay(){}
}
