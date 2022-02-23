package library.model;

import javax.persistence.Entity;

@Entity
public class Client extends User{

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
