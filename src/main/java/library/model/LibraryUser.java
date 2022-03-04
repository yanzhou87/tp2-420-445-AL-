package library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LibraryUser")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User_type", discriminatorType = DiscriminatorType.STRING)
public abstract class LibraryUser {

    @Id
    @GeneratedValue(generator = "libraryUser_seq")
    private long id;

    private String firstName;
    private String lastName;
    private int age;
    private String address;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;

}
