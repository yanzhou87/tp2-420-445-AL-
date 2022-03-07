package library.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("client")

public class Client extends LibraryUser {

    @OneToMany(mappedBy = "client",  fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Emprunt> emprunts;

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    private List<Amende> amendes = new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", library=" + library +
                "， amendes=" + amendes +
                '}';
    }
}
