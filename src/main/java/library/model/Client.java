package library.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("client")
public class Client extends LibraryUser {


    private String query = "";

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void borrow(){

    }

    public void returnArticle(){

    }

    public void toPay(){}
}
