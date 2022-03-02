package library.model;

import javax.persistence.*;

@Entity

@DiscriminatorValue("admin")
public class Admin extends LibraryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
