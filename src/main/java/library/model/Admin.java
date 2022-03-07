package library.model;

import javax.persistence.*;

@Entity

@DiscriminatorValue("admin")
public class Admin extends LibraryUser {

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", library=" + library +
                '}';
    }
}
