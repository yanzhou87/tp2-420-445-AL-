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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "LibraryUser_type", discriminatorType = DiscriminatorType.STRING)
@EqualsAndHashCode(exclude = "article")
public class Client extends LibraryUser {

    @OneToMany(mappedBy = "client",  fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Emprunt> emprunts;

    @OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
    private List<Amende> amendes = new ArrayList<>();
}
