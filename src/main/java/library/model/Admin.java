package library.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

@DiscriminatorValue("admin")
public class Admin extends LibraryUser {

    public boolean isAvailable(){return false;}

    public void addArticle(){}

    public void deleteArticle(){}

    public boolean isLate(){return  false;}

    public void applyFee(){}
}
